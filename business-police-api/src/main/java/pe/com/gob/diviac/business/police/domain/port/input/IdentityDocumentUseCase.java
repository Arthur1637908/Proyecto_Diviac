package pe.com.gob.diviac.business.police.domain.port.input;

import pe.com.gob.diviac.business.police.entity.IdentityDocument;

import java.util.List;
import java.util.UUID;

public interface IdentityDocumentUseCase {

    List<IdentityDocument> findIdentityDocumentsByPoliceId(UUID uuid);

    IdentityDocument saveIdentityDocument(IdentityDocument identityDocument);

    IdentityDocument updateIdentityDocument(IdentityDocument identityDocument);

    void deleteIdentityDocument(Long id);

}
