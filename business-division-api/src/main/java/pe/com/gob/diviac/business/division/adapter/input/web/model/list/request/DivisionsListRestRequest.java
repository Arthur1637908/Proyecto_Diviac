package pe.com.gob.diviac.business.division.adapter.input.web.model.list.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.division.util.StringUtils;
import pe.com.gob.diviac.business.division.util.constants.ValidationConstants;

@Getter
@Setter
@Schema(name = "DivisionsListRequestBusiness")
public class DivisionsListRestRequest {

    @Schema(description = "Code of the division", example = "COD01")
    @Pattern(regexp = ValidationConstants.REGEX_CODE_DIVISION)
    private String code;

    @Schema(description = "Name of the division", example = "SAN JUAN")
    @Pattern(regexp = ValidationConstants.REGEX_NAME_DIVISION)
    private String name;

    @Min(1)
    @NotNull
    @Schema(description = "Current page", example = "1", required = true)
    private Integer currentPage;

    @Min(1)
    @NotNull
    @Schema(description = "Page size", example = "20", required = true)
    private Integer pageSize;

    public void setCode(String code) {
        if (Objects.nonNull(code) && !code.trim().equals(StringUtils.EMPTY)) {
            this.code = code.trim().toUpperCase();
        }
    }

    public void setName(String name) {
        if (Objects.nonNull(name) && !name.trim().equals(StringUtils.EMPTY)) {
            this.name = name.trim().toUpperCase();
        }
    }
}
