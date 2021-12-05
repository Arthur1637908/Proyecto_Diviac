package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;

@Builder
@RequiredArgsConstructor
public class PoliceEntityConverter implements Function<Police, PoliceEntity> {

    private final Function<Parameter, ParameterEntity> parameterEntityConverter;

    @Override
    public PoliceEntity apply(Police police) {
        if (Objects.isNull(police)) {
            return null;
        }

        PoliceEntity policeEntity = new PoliceEntity();

        policeEntity.setId(this.getPoliceId(police.getId()));
        policeEntity.setCip(police.getCip());
        policeEntity.setFirstName(police.getFirstName());
        policeEntity.setSecondName(police.getSecondName());
        policeEntity.setLastName(police.getLastName());
        policeEntity.setSecondLastName(police.getSecondLastName());
        policeEntity.setPosition(parameterEntityConverter.apply(police.getPosition()));
        policeEntity.setGrade(parameterEntityConverter.apply(police.getGrade()));
        policeEntity.setSex(parameterEntityConverter.apply(police.getSex()));
        policeEntity.setDateOfBirth(police.getDateOfBirth());
        policeEntity.setPseudonym(police.getPseudonym());
        policeEntity.setCivilStatus(parameterEntityConverter.apply(police.getCivilStatus()));
        policeEntity.setState(Boolean.TRUE);

        //TODO: Implement audit logic
        policeEntity.setCreationUserId(String.valueOf(UUID.randomUUID()));
        policeEntity.setCreationUserRoleId(1);

        return policeEntity;
    }

    private UUID getPoliceId(UUID policeId) {
        if (Objects.isNull(policeId)) {
            return UUID.randomUUID();
        }

        return policeId;
    }
}
