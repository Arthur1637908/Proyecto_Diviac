package pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.list.request;

import lombok.Builder;

import java.util.Objects;
import java.util.function.Function;

import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.request.SituationPagedListRestRequest;
import pe.com.gob.diviac.business.police.entity.request.SituationPagedListRequest;

@Builder
public class SituationPagedListRequestConverter
        implements Function<SituationPagedListRestRequest, SituationPagedListRequest> {

    @Override
    public SituationPagedListRequest apply(SituationPagedListRestRequest situationPagedListRestRequest) {
        if (Objects.isNull(situationPagedListRestRequest)) {
            return null;
        }

        return SituationPagedListRequest.builder()
                .policeId(situationPagedListRestRequest.getPoliceId())
                .pageSize(situationPagedListRestRequest.getPageSize())
                .currentPage(situationPagedListRestRequest.getCurrentPage())
                .build();
    }
}
