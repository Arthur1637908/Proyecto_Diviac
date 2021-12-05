package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.list;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.channel.administration.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.list.DivisionListRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.DivisionDetailRestResponse;
import pe.com.gob.diviac.channel.administration.entity.common.response.PageResponse;
import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

@Builder
@RequiredArgsConstructor
public class DivisionListRestResponseConverter implements Function<DivisionListResponse, DivisionListRestResponse> {

    private final Function<PageResponse, PageRestResponse> pageRestResponseConverter;
    private final Function<Division, DivisionDetailRestResponse> divisionDetailRestResponseConverter;

    @Override
    public DivisionListRestResponse apply(DivisionListResponse divisionListResponse) {
        if (divisionListResponse != null) {
            return DivisionListRestResponse.builder()
                    .page(pageRestResponseConverter.apply(divisionListResponse.getPage()))
                    .divisions(this.buildDivisions(divisionListResponse.getDivisionList()))
                    .build();
        }

        return null;
    }

    private List<DivisionDetailRestResponse> buildDivisions(List<Division> divisionList) {
        if (divisionList != null && !divisionList.isEmpty()) {
            return divisionList.stream()
                    .map(divisionDetailRestResponseConverter)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
