package pe.com.gob.diviac.business.police.domain.port.output;

import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Police;

public interface PoliceDivisionPort {

    Division savePoliceDivision(Police police, Division division);

    Division updatePoliceDivision(Police police, Division division);

}
