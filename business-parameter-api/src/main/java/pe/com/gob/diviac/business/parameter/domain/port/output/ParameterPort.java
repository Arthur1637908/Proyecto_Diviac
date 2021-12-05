package pe.com.gob.diviac.business.parameter.domain.port.output;

import pe.com.gob.diviac.business.parameter.entity.Parameter;

import java.util.List;

public interface ParameterPort {

    List<Parameter> findAllByGroupCode(String groupCode);

}
