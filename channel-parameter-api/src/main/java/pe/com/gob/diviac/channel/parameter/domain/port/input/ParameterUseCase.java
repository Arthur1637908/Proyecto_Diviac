package pe.com.gob.diviac.channel.parameter.domain.port.input;

import java.util.List;

import pe.com.gob.diviac.channel.parameter.entity.Parameter;

public interface ParameterUseCase {

    List<Parameter> findByGroupCode(String groupCode);

}
