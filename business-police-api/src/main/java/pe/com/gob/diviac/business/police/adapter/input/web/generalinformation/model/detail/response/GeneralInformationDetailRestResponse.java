package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.detail.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.common.response.GeneralInformationRestResponse;

@Getter
@Setter
@Schema(name = "GeneralInformationDetailResponseBusiness")
public class GeneralInformationDetailRestResponse extends GeneralInformationRestResponse {

    @Builder
    public GeneralInformationDetailRestResponse(UUID id, String cip, DivisionRestResponse division,
                                                String firstName, String secondName, String lastName,
                                                String secondLastName, ParameterRestResponse position,
                                                ParameterRestResponse grade, ParameterRestResponse sex,
                                                String dateOfBirth, String pseudonym,
                                                ParameterRestResponse civilStatus, Boolean state) {
        super(id, cip, division, firstName, secondName, lastName, secondLastName, position, grade, sex,
                dateOfBirth, pseudonym, civilStatus, state);
    }
}
