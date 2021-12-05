package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PoliceRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.common.response.SituationRestResponse;

@Getter
@Setter
@Schema(name = "SaveSituationResponseBusiness")
public class SaveSituationRestResponse extends SituationRestResponse {

    @Builder
    public SaveSituationRestResponse(Long id, PoliceRestResponse police, ParameterRestResponse situationType,
                                     DivisionRestResponse division, String startDate, String endDate,
                                     String documentName, Boolean state) {
        super(id, police, situationType, division, startDate, endDate, documentName, state);
    }
}
