package pe.com.gob.diviac.channel.parameter.domain.interactor;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.gob.diviac.channel.parameter.domain.port.input.ParameterUseCase;
import pe.com.gob.diviac.channel.parameter.domain.port.output.ParameterPort;
import pe.com.gob.diviac.channel.parameter.entity.Parameter;

import java.util.List;

@Slf4j
@Builder
@RequiredArgsConstructor
public class ParameterInteractor implements ParameterUseCase {

    private final ParameterPort parameterPort;

    @Override
    public List<Parameter> findByGroupCode(String groupCode) {
        List<Parameter> parameterList;

        log.info("Starting ParameterInteractor.findByGroupCode");
        parameterList = parameterPort.findAllByGroupCode(groupCode);
        log.info("Finish ParameterInteractor.findByGroupCode successfully");

        return parameterList;
    }

}
