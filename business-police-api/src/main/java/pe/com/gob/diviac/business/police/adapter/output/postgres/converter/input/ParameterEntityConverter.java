package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.entity.Parameter;

@Builder
public class ParameterEntityConverter implements Function<Parameter, ParameterEntity> {

    @Override
    public ParameterEntity apply(Parameter parameter) {
        if (Objects.isNull(parameter)) {
            return null;
        }

        ParameterEntity parameterEntity = new ParameterEntity();

        parameterEntity.setId(parameter.getId());
        parameterEntity.setDescription(parameter.getName());
        parameterEntity.setState(parameter.getState());

        return parameterEntity;
    }
}
