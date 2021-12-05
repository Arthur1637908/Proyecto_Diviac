package pe.com.gob.diviac.business.police.adapter.input.web.police.converter.list.request;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.request.PolicePagedListRestRequest;
import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;

@Builder
public class PolicePagedListRestRequestConverter implements
        Function<PolicePagedListRestRequest, PolicePagedListRequest> {

    @Override
    public PolicePagedListRequest apply(PolicePagedListRestRequest policePagedListRestRequest) {
        if (Objects.isNull(policePagedListRestRequest)) {
            return null;
        }

        return PolicePagedListRequest.builder()
                .cip(policePagedListRestRequest.getCip())
                .name(policePagedListRestRequest.getName())
                .documentTypeId(policePagedListRestRequest.getDocumentTypeId())
                .documentNumber(policePagedListRestRequest.getDocumentNumber())
                .currentPage(policePagedListRestRequest.getCurrentPage())
                .pageSize(policePagedListRestRequest.getPageSize())
                .build();
    }
}
