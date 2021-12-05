package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.list;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.list.DivisionListRestRequest;
import pe.com.gob.diviac.channel.administration.entity.division.request.DivisionListRequest;

@Builder
public class DivisionListRestRequestConverter implements Function<DivisionListRestRequest, DivisionListRequest> {

    @Override
    public DivisionListRequest apply(DivisionListRestRequest divisionListRestRequest) {
        if (divisionListRestRequest != null) {
            return DivisionListRequest.builder()
                    .code(divisionListRestRequest.getCode())
                    .name(divisionListRestRequest.getName())
                    .currentPage(divisionListRestRequest.getCurrentPage())
                    .pageSize(divisionListRestRequest.getPageSize())
                    .build();
        }

        return null;
    }
}
