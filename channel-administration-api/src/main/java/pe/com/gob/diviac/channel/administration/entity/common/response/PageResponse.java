package pe.com.gob.diviac.channel.administration.entity.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageResponse {

    private Integer totalNumberOfItems;
    private Integer numberOfPages;
}
