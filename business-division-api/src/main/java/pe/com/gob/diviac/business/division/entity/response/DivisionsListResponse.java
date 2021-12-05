package pe.com.gob.diviac.business.division.entity.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.division.entity.Division;

@Getter
@Setter
@Builder
public class DivisionsListResponse {

    private PageResponse page;
    private List<Division> divisions;
}
