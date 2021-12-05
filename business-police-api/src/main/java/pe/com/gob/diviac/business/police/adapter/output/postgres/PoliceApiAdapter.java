package pe.com.gob.diviac.business.police.adapter.output.postgres;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.ParameterJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.PoliceJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.specification.PoliceEntitySpecification;
import pe.com.gob.diviac.business.police.domain.port.output.PolicePort;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Slf4j
@Builder
@RequiredArgsConstructor
public class PoliceApiAdapter implements PolicePort {

    private final PoliceJpaRepository policeJpaRepository;
    private final ParameterJpaRepository parameterJpaRepository;
    private final PoliceEntitySpecification policeEntitySpecification;
    private final Function<Police, PoliceEntity> policeEntityConverter;
    private final Function<Parameter, ParameterEntity> parameterEntityConverter;
    private final Function<Page<PoliceEntity>, PolicePagedListResponse> policePagedListResponseConverter;
    private final Function<PoliceEntity, Police> policeConverter;

    @Override
    public PolicePagedListResponse findPoliceByFilters(PolicePagedListRequest policePagedListRequest) {
        Pageable pageable;
        Page<PoliceEntity> policeEntityPage;
        PolicePagedListResponse policePagedListResponse;

        log.info("Starting PoliceApiAdapter.findPoliceByFilters");
        pageable = PageRequest.of(policePagedListRequest.getCurrentPage() - 1, policePagedListRequest.getPageSize());
        policeEntityPage = policeJpaRepository.findAll(policeEntitySpecification
                .getSpecificationForAllPolices(policePagedListRequest), pageable);
        policePagedListResponse = policePagedListResponseConverter.apply(policeEntityPage);
        log.info("Finish PoliceApiAdapter.findPoliceByFilters successfully");

        return policePagedListResponse;
    }

    @Override
    public Police findPoliceById(UUID id) {
        PoliceEntity policeEntity;
        Police police;

        log.info("Starting PoliceApiAdapter.findPoliceById");
        policeEntity = this.obtainPoliceByIdIfExists(id);
        police = policeConverter.apply(policeEntity);
        log.info("Finish PoliceApiAdapter.findPoliceById successfully");

        return police;
    }

    @Override
    public Police savePolice(Police policeToSave) {
        PoliceEntity policeEntityToSave;
        PoliceEntity policeEntitySaved;
        Police policeSaved;

        log.info("Starting PoliceApiAdapter.savePolice");
        this.validateIfExistsByCip(policeToSave.getCip());
        policeEntityToSave = policeEntityConverter.apply(policeToSave);
        policeEntitySaved = policeJpaRepository.save(policeEntityToSave);
        policeSaved = policeConverter.apply(policeEntitySaved);
        log.info("Finish PoliceApiAdapter.savePolice successfully");

        return policeSaved;
    }

    @Override
    public Police updatePolice(Police policeToUpdate) {
        PoliceEntity policeEntityFound;
        PoliceEntity policeEntityUpdated;
        Police policeUpdated;

        log.info("Starting PoliceApiAdapter.updatePolice");
        policeEntityFound = this.obtainPoliceByIdIfExists(policeToUpdate.getId());
        this.updatePoliceGeneralInformationFields(policeToUpdate, policeEntityFound);
        policeEntityUpdated = policeJpaRepository.save(policeEntityFound);
        policeUpdated = policeConverter.apply(policeEntityUpdated);
        log.info("Finish PoliceApiAdapter.updatePolice successfully");

        return policeUpdated;
    }

    @Override
    public void deletePoliceById(UUID id) {
        PoliceEntity policeEntity;

        log.info("Starting PoliceApiAdapter.deletePoliceById");
        policeEntity = this.obtainPoliceByIdIfExists(id);
        policeEntity.setState(Boolean.FALSE);
        policeJpaRepository.save(policeEntity);
        log.info("Finish PoliceApiAdapter.deletePoliceById successfully");
    }

    private PoliceEntity obtainPoliceByIdIfExists(UUID id) {
        Optional<PoliceEntity> optionalPoliceEntity;

        optionalPoliceEntity = policeJpaRepository.findByIdAndState(id, Boolean.TRUE);

        if (!optionalPoliceEntity.isPresent()) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_POLICE_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_POLICE_NOT_FOUND_DESCRIPTION);
        }

        return optionalPoliceEntity.get();
    }

    private void validateIfExistsByCip(String cip) {
        Optional<PoliceEntity> optionalPoliceEntity;

        optionalPoliceEntity = policeJpaRepository.findByCipAndState(cip, Boolean.TRUE);

        if (optionalPoliceEntity.isPresent()) {
            throw new DiviacStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorConstants.ERROR_POLICE_ALREADY_EXISTS_CODE,
                    ErrorConstants.ERROR_POLICE_ALREADY_EXISTS_DESCRIPTION);
        }
    }

    private void updatePoliceGeneralInformationFields(Police policeSource, PoliceEntity policeEntityTarget) {
        policeEntityTarget.setFirstName(policeSource.getFirstName());
        policeEntityTarget.setSecondName(policeSource.getSecondName());
        policeEntityTarget.setLastName(policeSource.getLastName());
        policeEntityTarget.setSecondLastName(policeSource.getSecondLastName());
        policeEntityTarget.setPosition(parameterEntityConverter.apply(policeSource.getPosition()));
        policeEntityTarget.setGrade(parameterEntityConverter.apply(policeSource.getGrade()));
        policeEntityTarget.setSex(parameterEntityConverter.apply(policeSource.getSex()));
        policeEntityTarget.setDateOfBirth(policeSource.getDateOfBirth());
        policeEntityTarget.setPseudonym(policeSource.getPseudonym());
        policeEntityTarget.setCivilStatus(parameterEntityConverter.apply(policeSource.getCivilStatus()));
        policeEntityTarget.setState(Boolean.TRUE);

        //TODO: Implement audit logic
        policeEntityTarget.setUpdateUserId(String.valueOf(UUID.randomUUID()));
        policeEntityTarget.setUpdateUserRoleId(1);
    }
}
