package pe.com.gob.diviac.channel.administration.domain.port.output;

import java.util.UUID;

import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.request.DivisionListRequest;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

public interface DivisionPort {

    DivisionListResponse findByCodeAndName(DivisionListRequest divisionListRequest);

    Division getDivisionDetail(UUID id);

    void save(Division divisionToSave);

    Division update(Division divisionToUpdate);

    void delete(UUID id);
}
