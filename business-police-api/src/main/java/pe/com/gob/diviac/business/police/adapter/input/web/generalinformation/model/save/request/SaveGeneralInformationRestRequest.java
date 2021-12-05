package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.save.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.common.request.GeneralInformationRestRequest;
import pe.com.gob.diviac.business.police.util.StringUtils;
import pe.com.gob.diviac.business.police.util.constants.ValidationConstants;

@Setter
@Getter
@Schema(name = "SaveGeneralInformationRequestBusiness")
public class SaveGeneralInformationRestRequest extends GeneralInformationRestRequest {

    @Pattern(regexp = ValidationConstants.CIP_REGEX)
    @Schema(description = "Police identification code", example = "9876543", required = true)
    private String cip;

    public SaveGeneralInformationRestRequest(String cip, UUID divisionId, String firstName, String secondName,
                                             String lastName, String secondLastName, Integer positionId,
                                             Integer gradeId, Integer sexId, String dateOfBirth,
                                             String pseudonym, Integer civilStatusId) {
        super(divisionId, firstName, secondName, lastName, secondLastName, positionId, gradeId,
                sexId, dateOfBirth, pseudonym, civilStatusId);
        this.cip = cip;
    }

    public void setCip(String cip) {
        if (Objects.nonNull(cip) && !cip.trim().equals(StringUtils.EMPTY)) {
            this.cip = cip.trim();
        }
    }
}
