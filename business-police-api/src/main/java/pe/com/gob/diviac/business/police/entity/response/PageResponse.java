package pe.com.gob.diviac.business.police.entity.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageResponse {

    private long totalNumberOfItems;
    private int numberOfPages;
}
