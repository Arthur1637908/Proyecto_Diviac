package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.list;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.channel.administration.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.DivisionDetailRestResponse;

@Getter
@Setter
@Builder
public class DivisionListRestResponse {

    @Schema(description = "Page information")
    private PageRestResponse page;

    @Schema(description = "Divisions information")
    private List<DivisionDetailRestResponse> divisions;
}
