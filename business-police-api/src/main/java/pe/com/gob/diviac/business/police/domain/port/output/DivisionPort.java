package pe.com.gob.diviac.business.police.domain.port.output;

import pe.com.gob.diviac.business.police.entity.Division;

import java.util.UUID;

public interface DivisionPort {

    Division findByDivisionId(UUID id);
}
