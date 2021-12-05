package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;

@Builder
@RequiredArgsConstructor
public class IdentityDocumentEntityConverter implements Function<IdentityDocument, IdentityDocumentEntity> {

    private final Function<Parameter, ParameterEntity> parameterEntityConverter;
    private final Function<Police, PoliceEntity> policeEntityConverter;

    @Override
    public IdentityDocumentEntity apply(IdentityDocument identityDocument) {
        if (Objects.isNull(identityDocument)) {
            return null;
        }

        IdentityDocumentEntity identityDocumentEntity = new IdentityDocumentEntity();

        identityDocumentEntity.setPolice(policeEntityConverter.apply(identityDocument.getPolice()));
        identityDocumentEntity.setDocumentType(parameterEntityConverter.apply(identityDocument.getDocumentType()));
        identityDocumentEntity.setDocumentNumber(identityDocument.getDocumentNumber());

        //TODO: Implement audit logic
        identityDocumentEntity.setCreationUserId(String.valueOf(UUID.randomUUID()));
        identityDocumentEntity.setCreationUserRoleId(1);
        identityDocumentEntity.setState(Boolean.TRUE);

        return identityDocumentEntity;
    }
}
