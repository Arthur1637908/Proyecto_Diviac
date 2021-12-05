package pe.com.gob.diviac.channel.administration.adapter.input.web.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageRestResponse {

    @Schema(description = "Total Number of items", example = "128")
    private Integer totalNumberOfItems;

    @Schema(description = "Number of pages", example = "10")
    private Integer numberOfPages;
}
