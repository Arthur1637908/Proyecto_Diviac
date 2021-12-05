package pe.com.gob.diviac.channel.administration.entity.division.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DivisionListRequest {

    private String code;
    private String name;
    private Integer currentPage;
    private Integer pageSize;
}
