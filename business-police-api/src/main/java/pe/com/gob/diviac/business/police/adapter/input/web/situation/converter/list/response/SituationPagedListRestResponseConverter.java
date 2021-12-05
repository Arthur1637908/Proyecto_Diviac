package pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.list.response;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response.SituationPagedListItemRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response.SituationPagedListRestResponse;
import pe.com.gob.diviac.business.police.entity.response.PageResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

@Builder
@RequiredArgsConstructor
public class SituationPagedListRestResponseConverter
        implements Function<SituationPagedListResponse, SituationPagedListRestResponse> {

    private final Function<PageResponse, PageRestResponse> pageRestResponseConverter;
    private final Function<SituationPagedListItemResponse, SituationPagedListItemRestResponse>
            situationPagedListItemRestResponseConverter;

    @Override
    public SituationPagedListRestResponse apply(SituationPagedListResponse situationPagedListResponse) {
        if (Objects.isNull(situationPagedListResponse)) {
            return null;
        }

        return SituationPagedListRestResponse.builder()
                .page(pageRestResponseConverter.apply(situationPagedListResponse.getPage()))
                .situations(this.getSituations(situationPagedListResponse.getSituations()))
                .build();
    }

    private List<SituationPagedListItemRestResponse> getSituations(List<SituationPagedListItemResponse> situations) {
        if (Objects.isNull(situations) || situations.isEmpty()) {
            return Collections.emptyList();
        }

        return situations.stream()
                .map(situationPagedListItemRestResponseConverter::apply)
                .collect(Collectors.toList());
    }
}
