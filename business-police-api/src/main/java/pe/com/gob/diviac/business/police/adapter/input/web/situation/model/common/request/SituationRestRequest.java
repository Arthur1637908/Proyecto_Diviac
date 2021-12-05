package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.common.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

import pe.com.gob.diviac.business.police.util.StringUtils;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SituationRestRequest {

    @Min(1)
    @NotNull
    @Schema(description = "Situation type parameter identifier", example = "1", required = true)
    private Integer situationTypeId;

    @Schema(description = "Division identifier", example = "817a083a-546d-41d3-9a71-f459b08e5a47")
    private UUID divisionId;

    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Schema(description = "Start date", example = "15/01/2021", format = "dd/MM/yyyy", required = true)
    private String startDate;

    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Schema(description = "End date", example = "15/02/2021", format = "dd/MM/yyyy", required = true)
    private String endDate;

    public void setStartDate(String startDate) {
        if (Objects.nonNull(startDate) && !startDate.trim().equals(StringUtils.EMPTY)) {
            this.startDate = startDate.trim();
        }
    }

    public void setEndDate(String endDate) {
        if (Objects.nonNull(endDate) && !endDate.trim().equals(StringUtils.EMPTY)) {
            this.endDate = endDate.trim();
        }
    }
}
