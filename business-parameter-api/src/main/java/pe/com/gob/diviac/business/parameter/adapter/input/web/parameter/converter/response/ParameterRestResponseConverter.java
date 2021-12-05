package pe.com.gob.diviac.business.parameter.adapter.input.web.parameter.converter.response;

import lombok.Builder;
import pe.com.gob.diviac.business.parameter.adapter.input.web.parameter.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.parameter.entity.Parameter;

import java.util.function.Function;

@Builder
public class ParameterRestResponseConverter implements Function<Parameter, ParameterRestResponse> {

    @Override
    public ParameterRestResponse apply(Parameter parameter) {
        if (parameter != null) {
            return ParameterRestResponse.builder()
                    .id(parameter.getId())
                    .name(parameter.getName())
                    .state(parameter.getState())
                    .build();
        }

        return null;
    }

}
