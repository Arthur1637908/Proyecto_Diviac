package pe.com.gob.diviac.business.division.adapter.input.web.model.common.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pe.com.gob.diviac.business.division.util.StringUtils;
import pe.com.gob.diviac.business.division.util.constants.ValidationConstants;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ContactRequestBusiness")
public class ContactRestRequest {

    @Pattern(regexp = ValidationConstants.REGEX_EMAIL_CONTACT)
    @Schema(description = "Email", example = "EMAIL@POLICIA.GOB.PE", required = true)
    private String email;

    @Pattern(regexp = ValidationConstants.REGEX_PHONENUMBER_CONTACT)
    @Schema(description = "Phone number", example = "5522113", required = true)
    private String phoneNumber;

    @Pattern(regexp = ValidationConstants.REGEX_ANNEXNUMBER_CONTACT)
    @Schema(description = "Annex number", example = "3212", required = true)
    private String annexNumber;

    public void setEmail(String email) {
        if (Objects.nonNull(email) && !email.trim().equals(StringUtils.EMPTY)) {
            this.email = email.trim().toUpperCase();
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (Objects.nonNull(phoneNumber) && !phoneNumber.trim().equals(StringUtils.EMPTY)) {
            this.phoneNumber = phoneNumber.trim();
        }
    }

    public void setAnnexNumber(String annexNumber) {
        if (Objects.nonNull(annexNumber) && !annexNumber.trim().equals(StringUtils.EMPTY)) {
            this.annexNumber = annexNumber.trim().toUpperCase();
        }
    }

}
