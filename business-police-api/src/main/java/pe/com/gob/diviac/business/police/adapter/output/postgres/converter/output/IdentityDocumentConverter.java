package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;

@Builder
@RequiredArgsConstructor
public class IdentityDocumentConverter implements Function<IdentityDocumentEntity, IdentityDocument> {

    private final Function<ParameterEntity, Parameter> parameterConverter;

    @Override
    public IdentityDocument apply(IdentityDocumentEntity identityDocumentEntity) {
        if (Objects.isNull(identityDocumentEntity)) {
            return null;
        }

        return IdentityDocument.builder()
                .id(identityDocumentEntity.getId())
                .documentType(parameterConverter.apply(identityDocumentEntity.getDocumentType()))
                .documentNumber(identityDocumentEntity.getDocumentNumber())
                .state(identityDocumentEntity.getState())
                .build();
    }
}
