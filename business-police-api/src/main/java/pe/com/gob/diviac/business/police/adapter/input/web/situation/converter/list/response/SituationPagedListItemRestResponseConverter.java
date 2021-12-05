package pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.list.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response.SituationPagedListItemRestResponse;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListItemResponse;
import pe.com.gob.diviac.business.police.util.DateUtils;
import pe.com.gob.diviac.business.police.util.enums.DateFormatEnum;

@Builder
@RequiredArgsConstructor
public class SituationPagedListItemRestResponseConverter
        implements Function<SituationPagedListItemResponse, SituationPagedListItemRestResponse> {

    private final Function<Parameter, ParameterRestResponse> parameterRestResponseConverter;
    private final Function<Division, DivisionRestResponse> divisionRestResponseConverter;

    @Override
    public SituationPagedListItemRestResponse apply(SituationPagedListItemResponse situationPagedListItemResponse) {
        if (Objects.isNull(situationPagedListItemResponse)) {
            return null;
        }

        return SituationPagedListItemRestResponse.builder()
                .id(situationPagedListItemResponse.getId())
                .situationType(parameterRestResponseConverter.apply(situationPagedListItemResponse.getSituationType()))
                .division(divisionRestResponseConverter.apply(situationPagedListItemResponse.getDivision()))
                .startDate(DateUtils.format(situationPagedListItemResponse.getStartDate(), DateFormatEnum.DD_MM_YYYY))
                .endDate(DateUtils.format(situationPagedListItemResponse.getEndDate(), DateFormatEnum.DD_MM_YYYY))
                .documentName(situationPagedListItemResponse.getDocumentName())
                .state(situationPagedListItemResponse.getState() )
                .build();
    }
}
