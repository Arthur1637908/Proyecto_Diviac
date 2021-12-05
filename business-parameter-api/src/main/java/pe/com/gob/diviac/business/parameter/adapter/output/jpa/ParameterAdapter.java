package pe.com.gob.diviac.business.parameter.adapter.output.jpa;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ParameterEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.ParameterRepository;
import pe.com.gob.diviac.business.parameter.domain.port.output.ParameterPort;
import pe.com.gob.diviac.business.parameter.entity.Parameter;

@Slf4j
@Builder
@RequiredArgsConstructor
public class ParameterAdapter implements ParameterPort {

    private final ParameterRepository parameterRepository;
    private final Function<ParameterEntity, Parameter> parameterConverter;

    @Override
    public List<Parameter> findAllByGroupCode(String groupCode) {
        List<Parameter> parameterList;

        log.info("Starting ParameterAdapter.findAllByGroupCode");
        parameterList = parameterRepository.findAllByParameterGroupCodeAndParameterGroupState(groupCode, Boolean.TRUE)
                .stream()
                .map(parameterConverter)
                .collect(Collectors.toList());
        log.info("Finish ParameterAdapter.findAllByGroupCode successfully");

        return parameterList;
    }

}
