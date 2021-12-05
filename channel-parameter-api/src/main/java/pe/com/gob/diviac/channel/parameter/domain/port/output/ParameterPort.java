package pe.com.gob.diviac.channel.parameter.domain.port.output;

import pe.com.gob.diviac.channel.parameter.entity.Parameter;

import java.util.List;

public interface ParameterPort {

    List<Parameter> findAllByGroupCode(String groupCode);

}
