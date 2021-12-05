package pe.com.gob.diviac.business.police.domain.interactor;

import java.util.UUID;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.transaction.annotation.Transactional;
import pe.com.gob.diviac.business.police.domain.port.input.GeneralInformationUseCase;
import pe.com.gob.diviac.business.police.domain.port.output.PoliceDivisionPort;
import pe.com.gob.diviac.business.police.domain.port.output.PolicePort;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Police;

@Slf4j
@Builder
@RequiredArgsConstructor
public class GeneralInformationInteractor implements GeneralInformationUseCase {

    private final PolicePort policePort;
    private final PoliceDivisionPort policeDivisionPort;

    @Override
    public Police getPoliceGeneralInformationDetail(UUID policeId) {
        Police policeFound;

        log.info("Starting GeneralInformationInteractor.getPoliceGeneralInformationDetail");
        policeFound = policePort.findPoliceById(policeId);
        log.info("Finish GeneralInformationInteractor.getPoliceGeneralInformationDetail successfully");

        return policeFound;
    }

    @Override
    @Transactional
    public Police savePoliceGeneralInformation(Police policeToSave) {
        Police policeSaved;
        Division divisionAssigned;

        log.info("Starting GeneralInformationInteractor.savePoliceGeneralInformation");
        policeSaved = policePort.savePolice(policeToSave);
        divisionAssigned = policeDivisionPort.savePoliceDivision(policeSaved, policeToSave.getDivision());
        policeSaved.setDivision(divisionAssigned);
        log.info("Finish GeneralInformationInteractor.savePoliceGeneralInformation successfully");

        return policeSaved;
    }

    @Override
    @Transactional
    public Police updateGeneralInformation(Police policeToUpdate) {
        Police policeUpdated;
        Division divisionAssigned;

        log.info("Starting GeneralInformationInteractor.updateGeneralInformation");
        policeUpdated = policePort.updatePolice(policeToUpdate);
        divisionAssigned = policeDivisionPort.updatePoliceDivision(policeUpdated, policeToUpdate.getDivision());
        policeUpdated.setDivision(divisionAssigned);
        log.info("Finish GeneralInformationInteractor.updateGeneralInformation successfully");

        return policeUpdated;
    }
}
