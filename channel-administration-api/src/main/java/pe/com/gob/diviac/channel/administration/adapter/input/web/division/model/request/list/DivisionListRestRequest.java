package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.list;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import pe.com.gob.diviac.channel.administration.utils.constants.ValidationConstants;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DivisionListRestRequest {

    @Pattern(regexp = ValidationConstants.REGEX_FILTER_CODE_DIVISION)
    @Schema(description = "Code", example = "DIV01")
    private String code;

    @Pattern(regexp = ValidationConstants.REGEX_FILTER_NAME_DIVISION)
    @Schema(description = "Name", example = "División Los Olivos")
    private String name;

    @NotNull
    @Min(1)
    @Schema(description = "Current page", example = "1", required = true)
    private Integer currentPage;

    @NotNull
    @Min(1)
    @Schema(description = "Page size", example = "15", required = true)
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
