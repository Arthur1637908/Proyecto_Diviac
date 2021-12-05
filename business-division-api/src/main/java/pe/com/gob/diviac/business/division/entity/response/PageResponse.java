package pe.com.gob.diviac.business.division.entity.response;

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
