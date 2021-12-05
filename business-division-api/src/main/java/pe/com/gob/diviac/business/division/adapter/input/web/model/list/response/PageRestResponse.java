package pe.com.gob.diviac.business.division.adapter.input.web.model.list.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "PageResponseBusiness")
public class PageRestResponse {

    @Schema(description = "Total number of items", example = "1", required = true)
    private Integer totalNumberOfItems;

    @Schema(description = "Page number current", example = "1", required = true)
    private Integer numberOfPages;

}