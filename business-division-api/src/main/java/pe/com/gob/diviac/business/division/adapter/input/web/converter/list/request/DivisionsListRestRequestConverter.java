package pe.com.gob.diviac.business.division.adapter.input.web.converter.list.request;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.division.adapter.input.web.model.list.request.DivisionsListRestRequest;
import pe.com.gob.diviac.business.division.entity.request.DivisionsListRequest;

@Builder
public class DivisionsListRestRequestConverter implements Function<DivisionsListRestRequest, DivisionsListRequest> {

    @Override
    public DivisionsListRequest apply(DivisionsListRestRequest divisionsListRestRequest) {
        if (Objects.isNull(divisionsListRestRequest)) {
            return null;
        }

        return DivisionsListRequest.builder()
                .code(divisionsListRestRequest.getCode())
                .name(divisionsListRestRequest.getName())
                .currentPage(divisionsListRestRequest.getCurrentPage())
                .pageSize(divisionsListRestRequest.getPageSize())
                .build();
    }
}
