package pe.com.gob.diviac.business.police.adapter.output.postgres;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.PoliceDivisionEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceDivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.DivisionJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.PoliceDivisionJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.PoliceJpaRepository;
import pe.com.gob.diviac.business.police.domain.port.output.PoliceDivisionPort;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Slf4j
@Builder
@RequiredArgsConstructor
public class PoliceDivisionApiAdapter implements PoliceDivisionPort {

    private final PoliceJpaRepository policeJpaRepository;
    private final DivisionJpaRepository divisionJpaRepository;
    private final PoliceDivisionJpaRepository policeDivisionJpaRepository;
    private final Function<PoliceDivisionEntityConverter.Wrapper, PoliceDivisionEntity> policeDivisionEntityConverter;
    private final Function<DivisionEntity, Division> divisionConverter;

    @Override
    public Division savePoliceDivision(Police police, Division division) {
        PoliceEntity policeEntityFound;
        DivisionEntity divisionEntityFound;
        Division divisionAssigned;

        log.info("Starting DivisionApiAdapter.savePoliceDivision");
        policeEntityFound = this.obtainPoliceIfExists(police.getId());
        divisionEntityFound = this.obtainDivisionIfExists(division.getId());
        divisionAssigned = this.savePoliceDivisionRelation(policeEntityFound, divisionEntityFound);
        log.info("Finishing DivisionApiAdapter.savePoliceDivision successfully");

        return divisionAssigned;
    }

    @Override
    public Division updatePoliceDivision(Police police, Division division) {
        PoliceEntity policeEntityFound;
        DivisionEntity divisionEntityFound;
        PoliceDivisionEntity policeDivisionEntityFound;
        Division divisionAssigned;

        log.info("Starting DivisionApiAdapter.updatePoliceDivision");
        policeEntityFound = this.obtainPoliceIfExists(police.getId());
        divisionEntityFound = this.obtainDivisionIfExists(division.getId());
        policeDivisionEntityFound = this.obtainPoliceDivisionRelationIfExists(police, division);

        if (Objects.isNull(policeDivisionEntityFound)) {
            this.disabledEnableDivisionPoliceRelation(police.getId());
            divisionAssigned = this.savePoliceDivisionRelation(policeEntityFound, divisionEntityFound);
            log.info("Finishing DivisionApiAdapter.updatePoliceDivision successfully");

            return divisionAssigned;
        }

        divisionAssigned = divisionConverter.apply(policeDivisionEntityFound.getDivision());
        log.info("Finishing DivisionApiAdapter.updatePoliceDivision successfully");

        return divisionAssigned;
    }

    private PoliceDivisionEntityConverter.Wrapper buildWrapper(PoliceEntity policeEntity,
                                                               DivisionEntity divisionEntity) {
        return PoliceDivisionEntityConverter.Wrapper.builder()
                .policeEntity(policeEntity)
                .divisionEntity(divisionEntity)
                .build();
    }

    private PoliceEntity obtainPoliceIfExists(UUID policeId) {
        Optional<PoliceEntity> optionalPoliceEntityFound;

        optionalPoliceEntityFound = policeJpaRepository.findByIdAndState(policeId, Boolean.TRUE);

        if (!optionalPoliceEntityFound.isPresent()) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_POLICE_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_POLICE_NOT_FOUND_DESCRIPTION);
        }

        return optionalPoliceEntityFound.get();
    }

    private DivisionEntity obtainDivisionIfExists(UUID divisionId) {
        Optional<DivisionEntity> optionalDivisionEntityFound;

        optionalDivisionEntityFound = divisionJpaRepository.findByIdAndState(divisionId, Boolean.TRUE);

        if (!optionalDivisionEntityFound.isPresent()) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_DIVISION_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_DIVISION_NOT_FOUND_DESCRIPTION);
        }

        return optionalDivisionEntityFound.get();
    }

    private Division savePoliceDivisionRelation(PoliceEntity policeEntityFound, DivisionEntity divisionEntityFound) {
        PoliceDivisionEntity policeDivisionEntityToSave;
        PoliceDivisionEntity policeDivisionEntitySaved;
        Division divisionAssigned;

        policeDivisionEntityToSave = policeDivisionEntityConverter.apply(
                this.buildWrapper(policeEntityFound, divisionEntityFound));
        policeDivisionEntitySaved = policeDivisionJpaRepository.save(policeDivisionEntityToSave);
        divisionAssigned = divisionConverter.apply(policeDivisionEntitySaved.getDivision());

        return divisionAssigned;
    }

    private PoliceDivisionEntity obtainPoliceDivisionRelationIfExists(Police police, Division division) {
        Optional<PoliceDivisionEntity> optionalPoliceDivisionEntityFound;

        optionalPoliceDivisionEntityFound = policeDivisionJpaRepository
                .findByPoliceIdAndDivisionIdAndState(police.getId(), division.getId(), Boolean.TRUE);

        return optionalPoliceDivisionEntityFound.orElse(null);
    }

    private void disabledEnableDivisionPoliceRelation(UUID policeId) {
        Optional<PoliceDivisionEntity> optionalPoliceDivisionEntityEnabled;
        PoliceDivisionEntity policeDivisionEntityEnabled;

        optionalPoliceDivisionEntityEnabled =  policeDivisionJpaRepository.findByPoliceIdAndState(policeId, Boolean.TRUE);

        if (optionalPoliceDivisionEntityEnabled.isPresent()) {
            policeDivisionEntityEnabled = optionalPoliceDivisionEntityEnabled.get();
            policeDivisionEntityEnabled.setState(Boolean.FALSE);
            //TODO: Implement audit logic
            policeDivisionEntityEnabled.setUpdateUserId(String.valueOf(UUID.randomUUID()));
            policeDivisionEntityEnabled.setUpdateUserRoleId(1);

            policeDivisionJpaRepository.save(policeDivisionEntityEnabled);
        }
    }
}
