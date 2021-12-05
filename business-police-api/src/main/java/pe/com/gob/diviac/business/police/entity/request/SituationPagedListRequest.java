package pe.com.gob.diviac.business.police.entity.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class SituationPagedListRequest {

    private UUID policeId;
    private int currentPage;
    private int pageSize;
}
