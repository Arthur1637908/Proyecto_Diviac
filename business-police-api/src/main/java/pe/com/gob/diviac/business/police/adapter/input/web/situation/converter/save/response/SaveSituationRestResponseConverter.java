package pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.save.response;

import lombok.Builder;

import java.util.Objects;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PoliceRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.response.SaveSituationRestResponse;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.util.DateUtils;
import pe.com.gob.diviac.business.police.util.enums.DateFormatEnum;

@Builder
@RequiredArgsConstructor
public class SaveSituationRestResponseConverter implements Function<Situation, SaveSituationRestResponse> {

    private final Function<Police, PoliceRestResponse> policeRestResponseConverter;
    private final Function<Parameter, ParameterRestResponse> parameterRestResponseConverter;
    private final Function<Division, DivisionRestResponse> divisionRestResponseConverter;

    @Override
    public SaveSituationRestResponse apply(Situation situation) {
        if (Objects.isNull(situation)) {
            return null;
        }

        return SaveSituationRestResponse.builder()
                .id(situation.getId())
                .police(policeRestResponseConverter.apply(situation.getPolice()))
                .situationType(parameterRestResponseConverter.apply(situation.getSituationType()))
                .division(divisionRestResponseConverter.apply(situation.getDivision()))
                .startDate(DateUtils.format(situation.getStartDate(), DateFormatEnum.DD_MM_YYYY))
                .endDate(DateUtils.format(situation.getEndDate(), DateFormatEnum.DD_MM_YYYY))
                .documentName(situation.getDocumentName())
                .state(situation.getState())
                .build();
    }
}
