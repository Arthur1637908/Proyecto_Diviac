package pe.com.gob.diviac.business.division.adapter.input.web.model.common.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pe.com.gob.diviac.business.division.util.StringUtils;
import pe.com.gob.diviac.business.division.util.constants.ValidationConstants;

@Getter
@Setter
@AllArgsConstructor
public class DivisionRestRequest {

    @Pattern(regexp = ValidationConstants.REGEX_ACRONYM_DIVISION)
    @Schema(description = "Acronym", example = "SGL")
    private String acronym;

    @Pattern(regexp = ValidationConstants.REGEX_NAME_DIVISION)
    @Schema(description = "Name", example = "SAN JUAN", required = true)
    private String name;

    @Pattern(regexp = ValidationConstants.REGEX_DESCRIPTION_DIVISION)
    @Schema(description = "Description", example = "DIVISION UBICADA EN EL DISTRITO...")
    private String description;

    @Valid
    @NotNull
    @Schema(description = "Address information", required = true)
    private AddressRestRequest address;

    @Valid
    @NotNull
    @Schema(description = "Contact information", required = true)
    private ContactRestRequest contact;

    public void setAcronym(String acronym) {
        if (Objects.nonNull(acronym) && !acronym.trim().equals(StringUtils.EMPTY)) {
            this.acronym = acronym.trim().toUpperCase();
        }
    }

    public void setName(String name) {
        if (Objects.nonNull(name) && !name.trim().equals(StringUtils.EMPTY)) {
            this.name = name.trim().toUpperCase();
        }
    }

    public void setDescription(String description) {
        if (Objects.nonNull(description) && !description.trim().equals(StringUtils.EMPTY)) {
            this.description = description.trim().toUpperCase();
        }
    }
}
