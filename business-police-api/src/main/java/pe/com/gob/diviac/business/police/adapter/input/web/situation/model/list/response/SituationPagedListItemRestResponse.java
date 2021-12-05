package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;

@Getter
@Setter
@Builder
@Schema(name = "SituationPagedListItemResponseBusiness")
public class SituationPagedListItemRestResponse {

    @Schema(description = "Situation identifier", example = "1")
    private Long id;

    @Schema(description = "Situation type information")
    private ParameterRestResponse situationType;

    @Schema(description = "Division information")
    private DivisionRestResponse division;

    @Schema(description = "Start date", example = "21/03/2021", format = "dd/MM/yyyy")
    private String startDate;

    @Schema(description = "End date", example = "21/03/2022", format = "dd/MM/yyyy")
    private String endDate;

    @Schema(description = "Document name", example = "situation.pdf")
    private String documentName;

    @Schema(description = "State", example = "true")
    private Boolean state;
}
