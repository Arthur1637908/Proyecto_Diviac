package pe.com.gob.diviac.business.police.domain.interactor;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import org.springframework.transaction.annotation.Transactional;

import pe.com.gob.diviac.business.police.domain.port.input.PoliceUseCase;
import pe.com.gob.diviac.business.police.domain.port.output.IdentityDocumentPort;
import pe.com.gob.diviac.business.police.domain.port.output.PolicePort;
import pe.com.gob.diviac.business.police.domain.port.output.SituationPort;
import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;

@Slf4j
@Builder
@AllArgsConstructor
public class PoliceInteractor implements PoliceUseCase {

    private final PolicePort policePort;
    private final SituationPort situationPort;
    private final IdentityDocumentPort identityDocumentPort;

    @Override
    public PolicePagedListResponse findPoliceByFilters(PolicePagedListRequest policePagedListRequest) {
        PolicePagedListResponse policePagedListResponse;

        log.info("Starting PoliceInteractor.findPoliceByFilters");
        policePagedListResponse = policePort.findPoliceByFilters(policePagedListRequest);
        log.info("Finish PoliceInteractor.findPoliceByFilters successfully");

        return policePagedListResponse;
    }

    @Override
    @Transactional
    public void deletePolice(UUID id) {
        log.info("Starting PoliceInteractor.deletePolice");
        policePort.deletePoliceById(id);
        situationPort.deleteSituationByPoliceId(id);
        identityDocumentPort.deleteIdentityDocumentByPoliceId(id);
        log.info("Finish PoliceInteractor.deletePolice successfully");
    }
}
