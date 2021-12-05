package pe.com.gob.diviac.channel.parameter.adapter.input.web.parameter.converter.response;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.channel.parameter.adapter.input.web.parameter.model.response.ParameterRestResponse;
import pe.com.gob.diviac.channel.parameter.entity.Parameter;

@Builder
public class ParameterRestResponseConverter implements Function<Parameter, ParameterRestResponse> {

    @Override
    public ParameterRestResponse apply(Parameter parameter) {
        if (parameter != null) {
            return ParameterRestResponse.builder()
                    .id(parameter.getId())
                    .name(parameter.getName())
                    .build();
        }

        return null;
    }

}
