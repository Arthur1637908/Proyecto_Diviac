package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.update.request;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.function.Function;

import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.update.request.UpdateIdentityDocumentRestRequest;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;

@Builder
public class UpdateIdentityDocumentRestRequestConverter implements
        Function<UpdateIdentityDocumentRestRequestConverter.Wrapper, IdentityDocument> {

    @Override
    public IdentityDocument apply(UpdateIdentityDocumentRestRequestConverter.Wrapper wrapper) {
        if (Objects.isNull(wrapper) || Objects.isNull(wrapper.getId())
                || Objects.isNull(wrapper.getUpdateIdentityDocumentRestRequest())) {
            return null;
        }

        return IdentityDocument.builder()
                .id(wrapper.getId())
                .documentType(this.getDocumentType(wrapper.getUpdateIdentityDocumentRestRequest().getDocumentTypeId()))
                .documentNumber(wrapper.getUpdateIdentityDocumentRestRequest().getDocumentNumber())
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

    @Data
    @Builder
    public static class Wrapper {

        private Long id;
        private UpdateIdentityDocumentRestRequest updateIdentityDocumentRestRequest;
    }
}
