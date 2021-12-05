package pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response;

import lombok.Builder;

import java.util.Objects;
import java.util.function.Function;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.business.police.entity.response.PageResponse;

@Builder
public class PageRestResponseConverter implements Function<PageResponse, PageRestResponse> {

    @Override
    public PageRestResponse apply(PageResponse pageResponse) {
        if (Objects.isNull(pageResponse)) {
            return null;
        }

        return PageRestResponse.builder()
                .totalNumberOfItems(pageResponse.getTotalNumberOfItems())
                .numberOfPages(pageResponse.getNumberOfPages())
                .build();
    }
}
