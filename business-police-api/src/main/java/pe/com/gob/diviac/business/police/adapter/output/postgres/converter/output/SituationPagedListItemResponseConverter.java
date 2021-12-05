package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.SituationEntity;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListItemResponse;

@Builder
@RequiredArgsConstructor
public class SituationPagedListItemResponseConverter
        implements Function<SituationEntity, SituationPagedListItemResponse> {

    private final Function<ParameterEntity, Parameter> parameterConverter;
    private final Function<DivisionEntity, Division> divisionConverter;

    @Override
    public SituationPagedListItemResponse apply(SituationEntity situationEntity) {
        if (Objects.isNull(situationEntity)) {
            return null;
        }

        return SituationPagedListItemResponse.builder()
                .id(situationEntity.getId())
                .situationType(parameterConverter.apply(situationEntity.getSituationType()))
                .division(divisionConverter.apply(situationEntity.getDivision()))
                .startDate(situationEntity.getStartDate())
                .endDate(situationEntity.getEndDate())
                .documentName(situationEntity.getDocumentName())
                .state(situationEntity.getState())
                .build();
    }
}
