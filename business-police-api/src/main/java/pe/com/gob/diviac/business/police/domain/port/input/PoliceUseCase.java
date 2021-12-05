package pe.com.gob.diviac.business.police.domain.port.input;

import java.util.UUID;

import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;

public interface PoliceUseCase {

    PolicePagedListResponse findPoliceByFilters(PolicePagedListRequest policePagedListRequest);

    void deletePolice(UUID id);
}
