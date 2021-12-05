package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pe.com.gob.diviac.channel.administration.utils.constants.ValidationConstants;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateContactRestRequest {

    @NotBlank
    @Pattern(regexp = ValidationConstants.REGEX_EMAIL_CONTACT)
    @Schema(description = "Email", example = "EXAMPLE@POLICIA.GOB.PE")
    private String email;

    @NotBlank
    @Pattern(regexp = ValidationConstants.REGEX_PHONE_NUMBER_CONTACT)
    @Schema(description = "Phone number", example = "5555555")
    private String phoneNumber;

    @Pattern(regexp = ValidationConstants.REGEX_ANNEX_NUMBER_CONTACT)
    @Schema(description = "Annex number", example = "555")
    private String annexNumber;
}
