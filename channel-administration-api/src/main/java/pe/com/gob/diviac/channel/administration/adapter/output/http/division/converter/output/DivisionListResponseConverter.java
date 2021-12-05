package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionListRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.PageRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.common.response.PageResponse;
import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

@Builder
@RequiredArgsConstructor
public class DivisionListResponseConverter implements Function<DivisionListRestResponseBusiness, DivisionListResponse> {

    private final Function<PageRestBusiness, PageResponse> pageResponseConverter;
    private final Function<DivisionRestResponseBusiness, Division> divisionConverter;

    @Override
    public DivisionListResponse apply(DivisionListRestResponseBusiness divisionListRestResponseBusiness) {
        if (divisionListRestResponseBusiness != null) {
            return DivisionListResponse.builder()
                    .page(pageResponseConverter.apply(divisionListRestResponseBusiness.getPage()))
                    .divisionList(this.buildDivisionList(divisionListRestResponseBusiness.getDivisions()))
                    .build();
        }

        return null;
    }

    private List<Division> buildDivisionList(List<DivisionRestResponseBusiness> divisionRestResponseBusinessList) {
        if (divisionRestResponseBusinessList != null && !divisionRestResponseBusinessList.isEmpty()) {
            return divisionRestResponseBusinessList.stream()
                    .map(divisionConverter)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
