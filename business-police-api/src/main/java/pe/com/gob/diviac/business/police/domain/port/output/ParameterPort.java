package pe.com.gob.diviac.business.police.domain.port.output;

import pe.com.gob.diviac.business.police.entity.Parameter;

public interface ParameterPort {

    Parameter findByParameterId(Integer id);
}
