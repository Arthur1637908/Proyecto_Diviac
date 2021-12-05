package pe.com.gob.diviac.business.police.entity.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PolicePagedListRequest {

    private String cip;
    private String name;
    private Integer documentTypeId;
    private String documentNumber;
    private int currentPage;
    private int pageSize;
}
