package pe.com.gob.diviac.channel.parameter.adapter.output.http.parameter.converter;

import java.util.function.Function;

import lombok.Builder;
import pe.com.gob.diviac.adapter.contract.parameterv1.ParameterBusinessResponse;
import pe.com.gob.diviac.channel.parameter.entity.Parameter;

@Builder
public class ParameterConverter
        implements Function<ParameterBusinessResponse, Parameter> {

    @Override
    public Parameter apply(ParameterBusinessResponse parameterBusinessResponse) {
        if (parameterBusinessResponse != null) {
            return Parameter.builder()
                    .id(parameterBusinessResponse.getId())
                    .name(parameterBusinessResponse.getName())
                    .state(parameterBusinessResponse.isState())
                    .build();
        }

        return null;
    }
}
