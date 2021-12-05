package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.SituationEntity;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;

@Builder
@RequiredArgsConstructor
public class SituationEntityConverter implements Function<Situation, SituationEntity> {

    private final Function<Police, PoliceEntity> policeEntityConverter;
    private final Function<Parameter, ParameterEntity> parameterEntityConverter;
    private final Function<Division, DivisionEntity> divisionEntityConverter;

    @Override
    public SituationEntity apply(Situation situation) {
        if (Objects.isNull(situation)) {
            return null;
        }

        SituationEntity situationEntity = new SituationEntity();

        situationEntity.setPolice(policeEntityConverter.apply(situation.getPolice()));
        situationEntity.setSituationType(parameterEntityConverter.apply(situation.getSituationType()));
        situationEntity.setDivision(divisionEntityConverter.apply(situation.getDivision()));
        situationEntity.setStartDate(situation.getStartDate());
        situationEntity.setEndDate(situation.getEndDate());
        situationEntity.setDocumentName(situation.getDocumentName());
        situationEntity.setState(Boolean.TRUE);

        //TODO: Implement document path in SFTP server
        situationEntity.setDocumentPath(situation.getDocumentName());

        //TODO: Implement audit logic
        situationEntity.setCreationUserId(String.valueOf(UUID.randomUUID()));
        situationEntity.setCreationUserRoleId(1);

        return situationEntity;
    }
}
