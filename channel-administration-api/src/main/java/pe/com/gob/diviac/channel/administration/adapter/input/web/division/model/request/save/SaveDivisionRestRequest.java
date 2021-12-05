package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pe.com.gob.diviac.channel.administration.utils.constants.ValidationConstants;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveDivisionRestRequest {

    @Pattern(regexp = ValidationConstants.REGEX_ACRONYM_DIVISION)
    @Schema(description = "Acronym", example = "DIVLO")
    private String acronym;

    @NotBlank
    @Pattern(regexp = ValidationConstants.REGEX_NAME_DIVISION)
    @Schema(description = "Name", example = "DIVISION DE LOS OLIVOS")
    private String name;

    @Pattern(regexp = ValidationConstants.REGEX_DESCRIPTION_DIVISION)
    @Schema(description = "Description", example = "DIVISION UBICADA EN LOS OLIVOS")
    private String description;

    @Valid
    @Schema(description = "Address information")
    private SaveAddressRestRequest address;

    @Valid
    @Schema(description = "Contact information")
    private SaveContactRestRequest contact;
}
