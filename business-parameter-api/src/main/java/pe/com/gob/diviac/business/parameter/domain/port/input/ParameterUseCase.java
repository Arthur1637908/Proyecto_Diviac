package pe.com.gob.diviac.business.parameter.domain.port.input;

import pe.com.gob.diviac.business.parameter.entity.Parameter;

import java.util.List;

public interface ParameterUseCase {

    List<Parameter> findByGroupCode(String groupCode);

}
