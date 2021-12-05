package pe.com.gob.diviac.business.police.adapter.input.web.police.converter.list.response;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.response.PolicePagedListItemRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.response.PolicePagedListRestResponse;
import pe.com.gob.diviac.business.police.entity.response.PageResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;

@Builder
@RequiredArgsConstructor
public class PolicePagedListRestResponseConverter
        implements Function<PolicePagedListResponse, PolicePagedListRestResponse> {

    private final Function<PageResponse, PageRestResponse> pageRestResponseConverter;
    private final Function<PolicePagedListItemResponse, PolicePagedListItemRestResponse>
            policePagedListItemRestResponseConverter;

    @Override
    public PolicePagedListRestResponse apply(PolicePagedListResponse policePagedListResponse) {
        if (Objects.isNull(policePagedListResponse)) {
            return null;
        }

        return PolicePagedListRestResponse.builder()
                .page(pageRestResponseConverter.apply(policePagedListResponse.getPage()))
                .polices(this.getPolices(policePagedListResponse.getPolices()))
                .build();
    }

    private List<PolicePagedListItemRestResponse> getPolices(List<PolicePagedListItemResponse> polices) {
        if (Objects.isNull(polices) || polices.isEmpty()) {
            return Collections.emptyList();
        }

        return polices.stream()
                .map(policePagedListItemRestResponseConverter::apply)
                .collect(Collectors.toList());
    }
}
