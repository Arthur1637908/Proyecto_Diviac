package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.Data;

import pe.com.gob.diviac.business.police.entity.response.PageResponse;

@Builder
public class PageResponseConverter implements Function<PageResponseConverter.Wrapper, PageResponse> {

    @Override
    public PageResponse apply(PageResponseConverter.Wrapper wrapper) {
        if (Objects.isNull(wrapper)) {
            return null;
        }

        return PageResponse.builder()
                .totalNumberOfItems(wrapper.getTotalNumberOfItems())
                .numberOfPages(wrapper.getNumberOfPages())
                .build();
    }

    @Data
    @Builder
    public static class Wrapper {

        private long totalNumberOfItems;
        private int numberOfPages;
    }
}
