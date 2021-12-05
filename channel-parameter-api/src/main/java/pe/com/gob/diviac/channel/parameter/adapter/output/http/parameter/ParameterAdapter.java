package pe.com.gob.diviac.channel.parameter.adapter.output.http.parameter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.adapter.contract.parameterv1.ParameterBusinessResponse;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.common.client.ParameterClient;
import pe.com.gob.diviac.channel.parameter.domain.port.output.ParameterPort;
import pe.com.gob.diviac.channel.parameter.entity.Parameter;

@Slf4j
@Builder
@RequiredArgsConstructor
public class ParameterAdapter implements ParameterPort {

    private final ParameterClient parameterClient;
    private final Function<ParameterBusinessResponse, Parameter> parameterConverter;

    @Override
    public List<Parameter> findAllByGroupCode(String groupCode) {
        List<Parameter> parameterList;

        log.info("Starting ParameterAdapter.findAllByGroupCode");
        parameterList = parameterClient.findParametersByGroupCode(groupCode)
                .stream()
                .map(parameterConverter)
                .collect(Collectors.toList());
        log.info("Finish ParameterAdapter.findAllByGroupCode successfully");

        return parameterList;
    }
}
