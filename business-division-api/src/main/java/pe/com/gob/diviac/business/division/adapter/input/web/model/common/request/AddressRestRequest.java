package pe.com.gob.diviac.business.division.adapter.input.web.model.common.request;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

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
@Schema(name = "AddressRequestBusiness")
public class AddressRestRequest {

    @Pattern(regexp = ValidationConstants.REGEX_NAME_ADDRESS)
    @Schema(description = "Address name", example = "JR. PUNO", required = true)
    private String name;

    @Pattern(regexp = ValidationConstants.REGEX_NUMBER_ADDRESS)
    @Schema(description = "Address number", example = "123", required = true)
    private String number;

    @Min(1)
    @NotNull
    @Schema(description = "Address type identifier", example = "1", required = true)
    private Integer typeId;

    @Min(1)
    @NotNull
    @Schema(description = "District identifier", example = "1342", required = true)
    private Integer districtId;

    public void setName(String name) {
        if (Objects.nonNull(name) && !name.trim().equals(StringUtils.EMPTY)) {
            this.name = name.trim().toUpperCase();
        }
    }

    public void setNumber(String number) {
        if (Objects.nonNull(number) && !number.trim().equals(StringUtils.EMPTY)) {
            this.number = number.trim().toUpperCase();
        }
    }
}
