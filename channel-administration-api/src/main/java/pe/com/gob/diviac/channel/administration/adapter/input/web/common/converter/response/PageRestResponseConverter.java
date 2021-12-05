package pe.com.gob.diviac.channel.administration.adapter.input.web.common.converter.response;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.channel.administration.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.channel.administration.entity.common.response.PageResponse;

@Builder
public class PageRestResponseConverter implements Function<PageResponse, PageRestResponse> {

    @Override
    public PageRestResponse apply(PageResponse pageResponse) {
        if (pageResponse != null) {
            return PageRestResponse.builder()
                    .totalNumberOfItems(pageResponse.getTotalNumberOfItems())
                    .numberOfPages(pageResponse.getNumberOfPages())
                    .build();
        }

        return null;
    }
}
