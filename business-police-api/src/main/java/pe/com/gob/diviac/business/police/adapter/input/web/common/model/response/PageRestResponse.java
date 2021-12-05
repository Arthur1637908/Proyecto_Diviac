package pe.com.gob.diviac.business.police.adapter.input.web.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "PageResponseBusiness")
public class PageRestResponse {

    @Schema(description = "Total number of items", example = "128")
    private long totalNumberOfItems;

    @Schema(description = "Number of pages", example = "13")
    private int numberOfPages;
}
