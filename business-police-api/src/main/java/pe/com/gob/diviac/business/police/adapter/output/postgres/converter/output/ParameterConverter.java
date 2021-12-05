package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.entity.Parameter;

@Builder
public class ParameterConverter implements Function<ParameterEntity, Parameter> {

    @Override
    public Parameter apply(ParameterEntity parameterEntity) {
        if (Objects.isNull(parameterEntity)) {
            return null;
        }

        return Parameter.builder()
                .id(parameterEntity.getId())
                .name(parameterEntity.getDescription())
                .state(parameterEntity.getState())
                .build();
    }
}
