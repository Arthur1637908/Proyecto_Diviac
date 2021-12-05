package pe.com.gob.diviac.business.police.domain.port.input;

import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.request.SituationPagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

public interface SituationUseCase {

    SituationPagedListResponse findSituationsByFilters(SituationPagedListRequest situationPagedListRequest);

    Situation saveSituation(Situation situationToSave);

    Situation updateSituation(Situation situationToUpdate);

    void deleteSituation(Long id);
}
