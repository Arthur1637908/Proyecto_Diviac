package pe.com.gob.diviac.business.division.domain.port.output;

import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Division;

import java.util.List;

public interface AddressPort {

    void insert(Address address);

    void update(Address address);

    void delete(Long addresId);

    Long getSequence();
}
