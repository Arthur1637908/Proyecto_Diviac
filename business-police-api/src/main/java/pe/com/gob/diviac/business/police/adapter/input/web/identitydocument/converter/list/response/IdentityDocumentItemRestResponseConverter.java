package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.list.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import lombok.RequiredArgsConstructor;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.list.response.IdentityDocumentItemRestResponse;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;

@Builder
@RequiredArgsConstructor
public class IdentityDocumentItemRestResponseConverter
        implements Function<IdentityDocument, IdentityDocumentItemRestResponse> {

    private final Function<Parameter, ParameterRestResponse> parameterRestResponseConverter;

    @Override
    public IdentityDocumentItemRestResponse apply(IdentityDocument identityDocument) {
        if (Objects.isNull(identityDocument)) {
            return null;
        }

        return IdentityDocumentItemRestResponse.builder()
                .id(identityDocument.getId())
                .documentType(parameterRestResponseConverter.apply(identityDocument.getDocumentType()))
                .documentNumber(identityDocument.getDocumentNumber())
                .state(identityDocument.getState())
                .build();
    }
}
