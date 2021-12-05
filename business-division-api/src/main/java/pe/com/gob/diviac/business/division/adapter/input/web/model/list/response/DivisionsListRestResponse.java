package pe.com.gob.diviac.business.division.adapter.input.web.model.list.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "DivisionsListResponseBusiness")
public class DivisionsListRestResponse {

    @Schema(description = "Page information")
    private PageRestResponse page;

    @Schema(description = "Divisions information")
    private List<DivisionsListItemRestResponse> divisions;
}
