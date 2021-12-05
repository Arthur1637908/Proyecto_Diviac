package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.update.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.save.response.SaveIdentityDocumentRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.update.response.UpdateIdentityDocumentRestResponse;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;

import java.util.Objects;
import java.util.function.Function;

@Builder
@RequiredArgsConstructor
public class UpdateIdentityDocumentRestResponseConverter
        implements Function<IdentityDocument, UpdateIdentityDocumentRestResponse> {

    private final Function<Parameter, ParameterRestResponse> parameterRestResponseConverter;

    @Override
    public UpdateIdentityDocumentRestResponse apply(IdentityDocument identityDocument) {
        if (Objects.isNull(identityDocument)) {
            return null;
        }

        return UpdateIdentityDocumentRestResponse.builder()
                .id(identityDocument.getId())
                .documentType(parameterRestResponseConverter.apply(identityDocument.getDocumentType()))
                .documentNumber(identityDocument.getDocumentNumber())
                .state(identityDocument.getState())
                .build();
    }
}
