package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PageRestResponse;

@Getter
@Setter
@Builder
@Schema(name = "SituationPagedListResponseBusiness")
public class SituationPagedListRestResponse {

    @Schema(description = "Page information")
    private PageRestResponse page;

    @Schema(description = "Situations information")
    private List<SituationPagedListItemRestResponse> situations;
}
