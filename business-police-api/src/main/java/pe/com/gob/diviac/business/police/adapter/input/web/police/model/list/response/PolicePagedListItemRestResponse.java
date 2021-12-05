package pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;

@Getter
@Setter
@Builder
@Schema(name = "PolicePagedListItemResponseBusiness")
public class PolicePagedListItemRestResponse {

    @Schema(description = "Identifier", example = "67ad327e-7e4b-463b-b6de-200c9c9fe530")
    private UUID id;

    @Schema(description = "Police identification code", example = "9654321")
    private String cip;

    @Schema(description = "Names", example = "Luis Alberto")
    private String names;

    @Schema(description = "LastNames", example = "Andrade Benites")
    private String lastNames;

    @Schema(description = "Division information")
    private DivisionRestResponse division;

    @Schema(description = "State", example = "true or false")
    private Boolean state;
}
