package pe.com.gob.diviac.business.division.entity.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DivisionsListRequest {

    private String code;
    private String name;
    private Integer currentPage;
    private Integer pageSize;

}
