package pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output;

import lombok.Builder;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ParameterEntity;
import pe.com.gob.diviac.business.parameter.entity.Parameter;

import java.util.function.Function;

@Builder
public class ParameterConverter implements Function<ParameterEntity, Parameter> {

    @Override
    public Parameter apply(ParameterEntity parameterEntity) {
        if (parameterEntity != null) {
            return Parameter.builder()
                    .id(parameterEntity.getIntIdParametro())
                    .name(parameterEntity.getVchDescParametro())
                    .state(parameterEntity.getBolEstado())
                    .build();
        }

        return null;
    }
}
