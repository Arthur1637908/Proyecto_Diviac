package pe.com.gob.diviac.business.police.domain.interactor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
import pe.com.gob.diviac.business.police.domain.port.input.IdentityDocumentUseCase;
import pe.com.gob.diviac.business.police.domain.port.output.IdentityDocumentPort;
import pe.com.gob.diviac.business.police.domain.port.output.ParameterPort;
import pe.com.gob.diviac.business.police.domain.port.output.PolicePort;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;

@Slf4j
@Builder
@AllArgsConstructor
public class IdentityDocumentInteractor implements IdentityDocumentUseCase {

    private final ParameterPort parameterPort;
    private final PolicePort policePort;
    private final IdentityDocumentPort identityDocumentPort;

    @Override
    public List<IdentityDocument> findIdentityDocumentsByPoliceId(UUID uuid) {
        List<IdentityDocument> identityDocumentList;

        log.info("Starting IdentityDocumentInteractor.findIdentityDocumentsByPoliceId");
        identityDocumentList = identityDocumentPort.findIdentityDocumentsByPoliceId(uuid);
        log.info("Finish IdentityDocumentInteractor.findIdentityDocumentsByPoliceId successfully");

        return identityDocumentList;
    }

    @Override
    @Transactional
    public IdentityDocument saveIdentityDocument(IdentityDocument identityDocument) {
        IdentityDocument completeIdentityDocument;
        IdentityDocument identityDocumentSaved;

        log.info("Starting IdentityDocumentInteractor.saveIdentityDocument");
        completeIdentityDocument = this.prepareIdentityDocumentToSave(identityDocument);
        identityDocumentSaved = identityDocumentPort.saveIdentityDocument(completeIdentityDocument);
        log.info("Finish IdentityDocumentInteractor.saveIdentityDocument successfully");

        return identityDocumentSaved;

    }

    @Override
    @Transactional
    public IdentityDocument updateIdentityDocument(IdentityDocument identityDocument) {
        IdentityDocument completeIdentityDocument;
        IdentityDocument identityDocumentUpdated;

        log.info("Starting IdentityDocumentInteractor.updateIdentityDocument");
        completeIdentityDocument = this.prepareIdentityDocumentToSave(identityDocument);
        identityDocumentUpdated = identityDocumentPort.updateIdentityDocument(completeIdentityDocument);
        log.info("Finish IdentityDocumentInteractor.updateIdentityDocument successfully");

        return identityDocumentUpdated;
    }

    @Override
    @Transactional
    public void deleteIdentityDocument(Long id) {
        log.info("Starting IdentityDocumentInteractor.updateIdentityDocument");
        identityDocumentPort.deleteIdentityDocumentById(id);
        log.info("Finish IdentityDocumentInteractor.updateIdentityDocument successfully");
    }

    private IdentityDocument prepareIdentityDocumentToSave(IdentityDocument identityDocument) {
        Parameter documentType;
        Police police;

        documentType = parameterPort.findByParameterId(identityDocument.getDocumentType().getId());
        identityDocument.setDocumentType(documentType);

        police = policePort.findPoliceById(identityDocument.getPolice().getId());
        identityDocument.setPolice(police);

        return identityDocument;
    }


}
