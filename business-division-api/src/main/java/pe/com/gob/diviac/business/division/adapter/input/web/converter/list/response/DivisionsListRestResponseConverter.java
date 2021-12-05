package pe.com.gob.diviac.business.division.adapter.input.web.converter.list.response;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.DivisionsListItemRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.DivisionsListRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.PageRestResponse;
import pe.com.gob.diviac.business.division.entity.Division;
import pe.com.gob.diviac.business.division.entity.response.DivisionsListResponse;
import pe.com.gob.diviac.business.division.entity.response.PageResponse;

@Builder
@RequiredArgsConstructor
public class DivisionsListRestResponseConverter implements Function<DivisionsListResponse, DivisionsListRestResponse> {

    private final Function<PageResponse, PageRestResponse> pageRestResponseConverter;
    private final Function<Division, DivisionsListItemRestResponse> divisionsListItemRestResponseConverter;

    @Override
    public DivisionsListRestResponse apply(DivisionsListResponse divisionsListResponse) {
        if (Objects.isNull(divisionsListResponse)) {
            return null;
        }

        return DivisionsListRestResponse.builder()
                .page(pageRestResponseConverter.apply(divisionsListResponse.getPage()))
                .divisions(this.getDivisions(divisionsListResponse.getDivisions()))
                .build();
    }

    private List<DivisionsListItemRestResponse> getDivisions(List<Division> divisions) {
        if (Objects.isNull(divisions) || divisions.isEmpty()) {
            return Collections.emptyList();
        }

        return divisions.stream()
                .map(divisionsListItemRestResponseConverter::apply)
                .collect(Collectors.toList());
    }
}
