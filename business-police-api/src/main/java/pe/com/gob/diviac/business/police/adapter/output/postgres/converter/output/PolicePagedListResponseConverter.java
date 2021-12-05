package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import lombok.Builder;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.entity.response.PageResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;

@Builder
@RequiredArgsConstructor
public class PolicePagedListResponseConverter
        implements Function<Page<PoliceEntity>, PolicePagedListResponse> {

    private final Function<PageResponseConverter.Wrapper, PageResponse> pageResponseConverter;
    private final Function<PoliceEntity, PolicePagedListItemResponse> policePagedListItemResponseConverter;

    @Override
    public PolicePagedListResponse apply(Page<PoliceEntity> policeEntityPage) {
        if (policeEntityPage == null) {
            return null;
        }

        return PolicePagedListResponse.builder()
                .page(pageResponseConverter.apply(this.getPage(policeEntityPage)))
                .polices(this.getPolices(policeEntityPage))
                .build();
    }

    private PageResponseConverter.Wrapper getPage(Page<PoliceEntity> policeEntityPage) {
        return PageResponseConverter.Wrapper.builder()
                .totalNumberOfItems(policeEntityPage.getTotalElements())
                .numberOfPages(policeEntityPage.getTotalPages())
                .build();
    }

    private List<PolicePagedListItemResponse> getPolices(Page<PoliceEntity> policeEntityPage) {
        return policeEntityPage.get()
                .map(policePagedListItemResponseConverter::apply)
                .collect(Collectors.toList());
    }
}
