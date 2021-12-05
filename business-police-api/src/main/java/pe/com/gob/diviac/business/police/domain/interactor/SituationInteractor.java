package pe.com.gob.diviac.business.police.domain.interactor;

import java.util.Objects;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import org.springframework.transaction.annotation.Transactional;
import pe.com.gob.diviac.business.police.domain.port.input.SituationUseCase;
import pe.com.gob.diviac.business.police.domain.port.output.DivisionPort;
import pe.com.gob.diviac.business.police.domain.port.output.FilePort;
import pe.com.gob.diviac.business.police.domain.port.output.ParameterPort;
import pe.com.gob.diviac.business.police.domain.port.output.PolicePort;
import pe.com.gob.diviac.business.police.domain.port.output.SituationPort;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.request.SituationPagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;
import pe.com.gob.diviac.business.police.util.enums.SituationTypeEnum;

@Slf4j
@Builder
public class SituationInteractor implements SituationUseCase {

    private final PolicePort policePort;
    private final DivisionPort divisionPort;
    private final ParameterPort parameterPort;
    private final SituationPort situationPort;
    private final FilePort filePort;

    @Override
    public SituationPagedListResponse findSituationsByFilters(SituationPagedListRequest situationPagedListRequest) {
        SituationPagedListResponse situationPagedListResponse;

        log.info("Starting SituationInteractor.findSituationsByFilters");
        situationPagedListResponse = situationPort.findSituationsByFilters(situationPagedListRequest);
        log.info("Finish SituationInteractor.findSituationsByFilters successfully");

        return situationPagedListResponse;
    }

    @Override
    @Transactional
    public Situation saveSituation(Situation situationToSave) {
        Situation completeSituation;
        Situation situationSaved;

        log.info("Starting SituationInteractor.saveSituation");
        completeSituation = this.prepareSituationObjectToSave(situationToSave);
        situationSaved = situationPort.saveSituation(completeSituation);
        log.info("Finish SituationInteractor.saveSituation successfully");

        return situationSaved;
    }

    @Override
    @Transactional
    public Situation updateSituation(Situation situationToUpdate) {
        Situation completeSituation;
        Situation situationUpdated;

        log.info("Starting SituationInteractor.updateSituation");
        completeSituation = this.prepareSituationObjectToUpdate(situationToUpdate);
        situationUpdated = situationPort.updateSituation(completeSituation);
        log.info("Finish SituationInteractor.updateSituation successfully");

        return situationUpdated;
    }

    @Override
    @Transactional
    public void deleteSituation(Long id) {
        log.info("Starting SituationInteractor.deleteSituation");
        situationPort.deleteSituation(id);
        log.info("Finish SituationInteractor.deleteSituation successfully");
    }

    private Situation prepareSituationObjectToSave(Situation situationToSave) {
        Police policeFound;
        Division divisionFound;
        Parameter situationTypeFound;

        policeFound = policePort.findPoliceById(situationToSave.getPolice().getId());
        situationToSave.setPolice(policeFound);

        if (SituationTypeEnum.SUB_UNIT_SUPPORT.getId().equals(situationToSave.getSituationType().getId())) {
            divisionFound = divisionPort.findByDivisionId(situationToSave.getDivision().getId());
            situationToSave.setDivision(divisionFound);
        }

        situationTypeFound = parameterPort.findByParameterId(situationToSave.getSituationType().getId());
        situationToSave.setSituationType(situationTypeFound);

        situationToSave.setDocumentPath(String.format("/path/%s", situationToSave.getDocumentName()));

        return situationToSave;
    }

    private Situation prepareSituationObjectToUpdate(Situation situationToUpdate) {
        Division divisionFound;
        Parameter situationTypeFound;

        if (SituationTypeEnum.SUB_UNIT_SUPPORT.getId().equals(situationToUpdate.getSituationType().getId())) {
            divisionFound = divisionPort.findByDivisionId(situationToUpdate.getDivision().getId());
            situationToUpdate.setDivision(divisionFound);
        }

        situationTypeFound = parameterPort.findByParameterId(situationToUpdate.getSituationType().getId());
        situationToUpdate.setSituationType(situationTypeFound);

        //TODO: Implement logic to get document path in SFTP server
        if (Objects.nonNull(situationToUpdate.getDocumentContent())
                && situationToUpdate.getDocumentContent().length > 0) {
            situationToUpdate.setDocumentPath(String.format("/path/%s", situationToUpdate.getDocumentName()));
        }

        return situationToUpdate;
    }
}
