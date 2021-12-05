package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.detail.response;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.detail.response.GeneralInformationDetailRestResponse;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.util.DateUtils;
import pe.com.gob.diviac.business.police.util.enums.DateFormatEnum;

@Builder
@RequiredArgsConstructor
public class GeneralInformationDetailRestResponseConverter
        implements Function<Police, GeneralInformationDetailRestResponse> {

    private final Function<Division, DivisionRestResponse> divisionRestResponseConverter;
    private final Function<Parameter, ParameterRestResponse> parameterRestResponseConverter;

    @Override
    public GeneralInformationDetailRestResponse apply(Police police) {
        if (police == null) {
            return null;
        }

        return GeneralInformationDetailRestResponse.builder()
                .id(police.getId())
                .cip(police.getCip())
                .division(divisionRestResponseConverter.apply(police.getDivision()))
                .firstName(police.getFirstName())
                .secondName(police.getSecondName())
                .lastName(police.getLastName())
                .secondLastName(police.getSecondLastName())
                .position(parameterRestResponseConverter.apply(police.getPosition()))
                .grade(parameterRestResponseConverter.apply(police.getGrade()))
                .sex(parameterRestResponseConverter.apply(police.getSex()))
                .dateOfBirth(DateUtils.format(police.getDateOfBirth(), DateFormatEnum.DD_MM_YYYY))
                .pseudonym(police.getPseudonym())
                .civilStatus(parameterRestResponseConverter.apply(police.getCivilStatus()))
                .state(police.getState())
                .build();
    }
}
