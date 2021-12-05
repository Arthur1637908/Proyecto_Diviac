package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.update.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.common.request.GeneralInformationRestRequest;

@Getter
@Setter
@Schema(name = "UpdateGeneralInformationRequestBusiness")
public class UpdateGeneralInformationRestRequest extends GeneralInformationRestRequest {

    public UpdateGeneralInformationRestRequest(UUID divisionId, String firstName,
                                               String secondName, String lastName, String secondLastName,
                                               Integer positionId, Integer gradeId, Integer sexId, String dateOfBirth,
                                               String pseudonym, Integer civilStatusId) {
        super(divisionId, firstName, secondName, lastName, secondLastName, positionId, gradeId,
                sexId, dateOfBirth, pseudonym, civilStatusId);
    }
}
