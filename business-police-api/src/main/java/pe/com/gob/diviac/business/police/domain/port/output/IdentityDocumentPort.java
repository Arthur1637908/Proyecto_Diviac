package pe.com.gob.diviac.business.police.domain.port.output;

import pe.com.gob.diviac.business.police.entity.IdentityDocument;

import java.util.List;
import java.util.UUID;

public interface IdentityDocumentPort {

    IdentityDocument saveIdentityDocument(IdentityDocument identityDocument);

    IdentityDocument updateIdentityDocument(IdentityDocument identityDocument);

    List<IdentityDocument> findIdentityDocumentsByPoliceId(UUID id);

    void deleteIdentityDocumentByPoliceId(UUID id);

    void deleteIdentityDocumentById(Long id);
}
