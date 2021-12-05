package pe.com.gob.diviac.channel.administration.entity.division.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.channel.administration.entity.common.response.PageResponse;
import pe.com.gob.diviac.channel.administration.entity.division.Division;

@Getter
@Setter
@Builder
public class DivisionListResponse {

    private PageResponse page;
    private List<Division> divisionList;
}
