package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.Objects;
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
    public class SituationConverter implements Function<SituationEntity, Situation> {

    private final Function<PoliceEntity, Police> policeConverter;
    private final Function<ParameterEntity, Parameter> parameterConverter;
    private final Function<DivisionEntity, Division> divisionConverter;

    @Override
    public Situation apply(SituationEntity situationEntity) {
        if (Objects.isNull(situationEntity)) {
            return null;
        }

        return Situation.builder()
                .id(situationEntity.getId())
                .police(policeConverter.apply(situationEntity.getPolice()))
                .situationType(parameterConverter.apply(situationEntity.getSituationType()))
                .division(divisionConverter.apply(situationEntity.getDivision()))
                .startDate(situationEntity.getStartDate())
                .endDate(situationEntity.getEndDate())
                .documentName(situationEntity.getDocumentName())
                .documentPath(situationEntity.getDocumentPath())
                .state(situationEntity.getState())
                .build();
    }
}
