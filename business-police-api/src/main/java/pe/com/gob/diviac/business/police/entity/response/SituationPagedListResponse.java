package pe.com.gob.diviac.business.police.entity.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SituationPagedListResponse {

    private PageResponse page;
    private List<SituationPagedListItemResponse> situations;
}
