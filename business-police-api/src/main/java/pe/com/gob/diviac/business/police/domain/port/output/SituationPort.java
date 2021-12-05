package pe.com.gob.diviac.business.police.domain.port.output;

import java.util.UUID;

import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.request.SituationPagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

public interface SituationPort {

    SituationPagedListResponse findSituationsByFilters(SituationPagedListRequest situationPagedListRequest);

    Situation saveSituation(Situation situationToSave);

    Situation updateSituation(Situation situationToUpdate);

    void deleteSituationByPoliceId(UUID id);

    void deleteSituation(Long id);
}
