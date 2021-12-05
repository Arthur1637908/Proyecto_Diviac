package pe.com.gob.diviac.business.division.adapter.input.web.converter.list.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.PageRestResponse;
import pe.com.gob.diviac.business.division.entity.response.PageResponse;

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
