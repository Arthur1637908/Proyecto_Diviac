package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class SaveAddressRestRequest {

    @NotBlank
    @Pattern(regexp = ValidationConstants.REGEX_NAME_ADDRESS)
    @Schema(description = "Name", example = "LOS TULIPANES")
    private String name;

    @NotBlank
    @Pattern(regexp = ValidationConstants.REGEX_NUMBER_ADDRESS)
    @Schema(description = "Number", example = "424")
    private String number;

    @NotNull
    @Min(1)
    @Schema(description = "Type identifier", example = "1")
    private Integer typeId;

    @NotNull
    @Min(1)
    @Schema(description = "District identifier", example = "1")
    private Integer districtId;
}
