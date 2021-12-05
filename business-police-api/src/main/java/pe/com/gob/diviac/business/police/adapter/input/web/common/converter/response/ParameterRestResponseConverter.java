package pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.entity.Parameter;

@Builder
public class ParameterRestResponseConverter implements Function<Parameter, ParameterRestResponse> {

    @Override
    public ParameterRestResponse apply(Parameter parameter) {
        if (parameter == null) {
            return null;
        }

        return ParameterRestResponse.builder()
                .id(parameter.getId())
                .name(parameter.getName())
                .state(parameter.getState())
                .build();
    }
}
