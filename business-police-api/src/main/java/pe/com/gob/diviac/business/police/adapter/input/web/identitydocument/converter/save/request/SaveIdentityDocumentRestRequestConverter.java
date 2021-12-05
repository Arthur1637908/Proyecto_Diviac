package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.save.request;

import lombok.Builder;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.save.request.SaveIdentityDocumentRestRequest;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;

@Builder
public class SaveIdentityDocumentRestRequestConverter
        implements Function<SaveIdentityDocumentRestRequest, IdentityDocument> {

    @Override
    public IdentityDocument apply(SaveIdentityDocumentRestRequest saveIdentityDocumentRestRequest) {
        if (Objects.isNull(saveIdentityDocumentRestRequest)) {
            return null;
        }

        return IdentityDocument.builder()
                .documentNumber(saveIdentityDocumentRestRequest.getDocumentNumber())
                .documentType(this.getDocumentType(saveIdentityDocumentRestRequest.getDocumentTypeId()))
                .police(this.getPolice(saveIdentityDocumentRestRequest.getPoliceId()))
                .build();
    }

    private Parameter getDocumentType(Integer documentTypeId) {
        if (Objects.isNull(documentTypeId)) {
            return null;
        }

        return Parameter.builder()
                .id(documentTypeId)
                .build();
    }

    private Police getPolice(UUID policeId) {
        if (Objects.isNull(policeId)) {
            return null;
        }

        return Police.builder()
                .id(policeId)
                .build();
    }
}
