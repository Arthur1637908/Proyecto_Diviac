package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.SituationEntity;
import pe.com.gob.diviac.business.police.entity.response.PageResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

@Builder
@RequiredArgsConstructor
public class SituationPagedListResponseConverter
        implements Function<Page<SituationEntity>, SituationPagedListResponse> {

    private final Function<PageResponseConverter.Wrapper, PageResponse> pageResponseConverter;
    private final Function<SituationEntity, SituationPagedListItemResponse> situationPagedListItemResponseConverter;

    @Override
    public SituationPagedListResponse apply(Page<SituationEntity> situationEntityPage) {
        if (Objects.isNull(situationEntityPage)) {
            return null;
        }

        return SituationPagedListResponse.builder()
                .page(pageResponseConverter.apply(this.getPage(situationEntityPage)))
                .situations(this.getSituations(situationEntityPage))
                .build();
    }

    private PageResponseConverter.Wrapper getPage(Page<SituationEntity> situationEntityPage) {
        return PageResponseConverter.Wrapper.builder()
                .totalNumberOfItems(situationEntityPage.getTotalElements())
                .numberOfPages(situationEntityPage.getTotalPages())
                .build();
    }

    private List<SituationPagedListItemResponse> getSituations(Page<SituationEntity> situationEntityPage) {
        return situationEntityPage.get()
                .map(situationPagedListItemResponseConverter::apply)
                .collect(Collectors.toList());
    }
}
