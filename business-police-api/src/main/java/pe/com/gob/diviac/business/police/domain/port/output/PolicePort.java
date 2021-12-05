package pe.com.gob.diviac.business.police.domain.port.output;

import java.util.UUID;

import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;

public interface PolicePort {

    PolicePagedListResponse findPoliceByFilters(PolicePagedListRequest policePagedListRequest);

    Police findPoliceById(UUID id);

    Police savePolice(Police policeToSave);

    Police updatePolice(Police policeToUpdate);

    void deletePoliceById(UUID id);

}
