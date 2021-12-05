package pe.com.gob.diviac.business.division.domain.port.output;

import java.util.List;
import java.util.UUID;

import pe.com.gob.diviac.business.division.entity.Division;
import pe.com.gob.diviac.business.division.entity.request.DivisionsListRequest;
import pe.com.gob.diviac.business.division.entity.response.PageResponse;

public interface DivisionPort {

    void insert(Division division);

    List<Division> findAllByCodeAndName(DivisionsListRequest divisionsListRequest);

    void update(Division division);

    void delete(UUID divisionId);

    Division findById(UUID divisionId);

    PageResponse getPage(DivisionsListRequest divisionsListRequest);

}
