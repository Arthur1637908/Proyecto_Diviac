package pe.com.gob.diviac.channel.administration.adapter.output.http.common.converter.output;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.divisionv1.PageRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.common.response.PageResponse;

@Builder
public class PageResponseConverter implements Function<PageRestBusiness, PageResponse> {

    @Override
    public PageResponse apply(PageRestBusiness pageRestBusiness) {
        if (pageRestBusiness != null) {
            return PageResponse.builder()
                    .totalNumberOfItems(pageRestBusiness.getTotalNumberOfItems())
                    .numberOfPages(pageRestBusiness.getNumberOfPages())
                    .build();
        }

        return null;
    }
}
