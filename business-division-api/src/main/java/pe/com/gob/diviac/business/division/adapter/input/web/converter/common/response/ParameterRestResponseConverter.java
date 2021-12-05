package pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response;

import lombok.Builder;

import java.util.Objects;
import java.util.function.Function;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ParameterRestResponse;
import pe.com.gob.diviac.business.division.entity.Parameter;

@Builder
public class ParameterRestResponseConverter implements Function<Parameter, ParameterRestResponse> {

    @Override
    public ParameterRestResponse apply(Parameter parameter) {
        if (Objects.isNull(parameter)) {
            return null;
        }

        return ParameterRestResponse.builder()
                .id(parameter.getId())
                .name(parameter.getName())
                .build();
    }
}
