package pe.com.gob.diviac.business.police.adapter.output.postgres;

import java.util.List;
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
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.SituationEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.ParameterJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.SituationJpaRepository;
import pe.com.gob.diviac.business.police.domain.port.output.SituationPort;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.request.SituationPagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Slf4j
@Builder
@RequiredArgsConstructor
public class SituationApiAdapter implements SituationPort {

    private final SituationJpaRepository situationJpaRepository;
    private final ParameterJpaRepository parameterJpaRepository;
    private final Function<Page<SituationEntity>, SituationPagedListResponse> situationPagedListResponseConverter;
    private final Function<Parameter, ParameterEntity> parameterEntityConverter;
    private final Function<Police, PoliceEntity> policeEntityConverter;
    private final Function<Division, DivisionEntity> divisionEntityConverter;
    private final Function<Situation, SituationEntity> situationEntityConverter;
    private final Function<SituationEntity, Situation> situationConverter;

    @Override
    public SituationPagedListResponse findSituationsByFilters(SituationPagedListRequest situationPagedListRequest) {
        Pageable pageable;
        Page<SituationEntity> situationEntityPage;
        SituationPagedListResponse situationPagedListResponse;

        log.info("Starting SituationApiAdapter.findSituationsByFilters");
        pageable = PageRequest.of(situationPagedListRequest.getCurrentPage() - 1 ,
                situationPagedListRequest.getPageSize());
        situationEntityPage = situationJpaRepository.findByPoliceIdAndState(situationPagedListRequest.getPoliceId(),
                Boolean.TRUE, pageable);
        situationPagedListResponse = situationPagedListResponseConverter.apply(situationEntityPage);
        log.info("Finish SituationApiAdapter.findSituationsByFilters successfully");

        return situationPagedListResponse;
    }

    @Override
    public Situation saveSituation(Situation situationToSave) {
        SituationEntity situationEntityToSave;
        SituationEntity situationEntitySaved;
        Situation situation;

        log.info("Starting SituationApiAdapter.saveSituation");
        situationEntityToSave = situationEntityConverter.apply(situationToSave);
        situationEntitySaved = situationJpaRepository.save(situationEntityToSave);
        situation = situationConverter.apply(situationEntitySaved);
        log.info("Finish SituationApiAdapter.saveSituation successfully");

        return situation;
    }

    @Override
    public Situation updateSituation(Situation situationToUpdate) {
        SituationEntity situationEntityFound;
        SituationEntity situationEntityUpdated;
        Situation situation;

        log.info("Starting SituationApiAdapter.updateSituation");
        situationEntityFound = this.obtainSituationIfExists(situationToUpdate.getId());
        this.changeFieldsValuesToUpdatePoliceSituation(situationToUpdate, situationEntityFound);
        situationEntityUpdated = situationJpaRepository.save(situationEntityFound);
        situation = situationConverter.apply(situationEntityUpdated);
        log.info("Finish SituationApiAdapter.updateSituation successfully");

        return situation;
    }

    @Override
    public void deleteSituationByPoliceId(UUID policeId) {
        Optional<List<SituationEntity>> optionalSituationEntityList;
        List<SituationEntity> situationEntityList;

        log.info("Starting SituationApiAdapter.deleteSituationByPoliceId");
        optionalSituationEntityList = situationJpaRepository.findByPoliceIdAndState(policeId, Boolean.TRUE);

        if (optionalSituationEntityList.isPresent()) {
            situationEntityList = optionalSituationEntityList.get();
            situationEntityList.forEach(situationEntity -> situationEntity.setState(Boolean.FALSE));
            situationJpaRepository.saveAll(situationEntityList);
        }

        log.info("Finish SituationApiAdapter.deleteSituationByPoliceId successfully");
    }

    @Override
    public void deleteSituation(Long id) {
        SituationEntity situationEntityFound;

        log.info("Starting SituationApiAdapter.deleteSituation");
        situationEntityFound = this.obtainSituationIfExists(id);
        this.changeFieldsValuesToDeletePoliceSituation(situationEntityFound);
        situationJpaRepository.save(situationEntityFound);
        log.info("Finish SituationApiAdapter.deleteSituation successfully");
    }

    private SituationEntity obtainSituationIfExists(Long id) {
        Optional<SituationEntity> optionalSituationEntity;

        optionalSituationEntity = situationJpaRepository.findByIdAndState(id, Boolean.TRUE);

        if (!optionalSituationEntity.isPresent()) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_SITUATION_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_SITUATION_NOT_FOUND_DESCRIPTION);
        }

        return optionalSituationEntity.get();
    }

    private void changeFieldsValuesToUpdatePoliceSituation(Situation situationToUpdate,
                                                           SituationEntity situationEntityFound) {
        situationEntityFound.setSituationType(parameterEntityConverter.apply(situationToUpdate.getSituationType()));
        situationEntityFound.setDivision(divisionEntityConverter.apply(situationToUpdate.getDivision()));
        situationEntityFound.setStartDate(situationToUpdate.getStartDate());
        situationEntityFound.setEndDate(situationToUpdate.getEndDate());
        situationEntityFound.setDocumentName(situationToUpdate.getDocumentName());
        situationEntityFound.setDocumentPath(situationToUpdate.getDocumentPath());

        //TODO: Implement audit logic
        situationEntityFound.setUpdateUserId(String.valueOf(UUID.randomUUID()));
        situationEntityFound.setUpdateUserRoleId(1);
    }

    private void changeFieldsValuesToDeletePoliceSituation(SituationEntity situationEntityFound) {
        situationEntityFound.setState(Boolean.FALSE);

        //TODO: Implement audit logic
        situationEntityFound.setUpdateUserId(String.valueOf(UUID.randomUUID()));
        situationEntityFound.setUpdateUserRoleId(1);
    }
}
