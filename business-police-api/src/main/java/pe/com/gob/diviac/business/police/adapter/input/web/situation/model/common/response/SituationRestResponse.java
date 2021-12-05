package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.common.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PoliceRestResponse;

@Getter
@Setter
@AllArgsConstructor
public class SituationRestResponse {

    @Schema(description = "Situation identifier", example = "1")
    private Long id;

    @Schema(description = "Police information")
    private PoliceRestResponse police;

    @Schema(description = "Situation type information")
    private ParameterRestResponse situationType;

    @Schema(description = "Division information")
    private DivisionRestResponse division;

    @Schema(description = "Start date", example = "20/12/2020")
    private String startDate;

    @Schema(description = "End date", example = "20/03/2021")
    private String endDate;

    @Schema(description = "Document name", example = "situacion_capitan.pdf")
    private String documentName;

    @Schema(description = "State", example = "true or false")
    private Boolean state;
}
