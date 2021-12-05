package pe.com.gob.diviac.business.police.adapter.input.web.police.converter.list.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.response.PolicePagedListItemRestResponse;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListItemResponse;

@Builder
@RequiredArgsConstructor
public class PolicePagedListItemRestResponseConverter
        implements Function<PolicePagedListItemResponse, PolicePagedListItemRestResponse> {

    private final Function<Division, DivisionRestResponse> divisionRestResponseConverter;

    @Override
    public PolicePagedListItemRestResponse apply(PolicePagedListItemResponse policePagedListItemResponse) {
        if (Objects.isNull(policePagedListItemResponse)) {
            return null;
        }

        return PolicePagedListItemRestResponse.builder()
                .id(policePagedListItemResponse.getId())
                .cip(policePagedListItemResponse.getCip())
                .names(policePagedListItemResponse.getNames())
                .lastNames(policePagedListItemResponse.getLastNames())
                .division(divisionRestResponseConverter.apply(policePagedListItemResponse.getDivision()))
                .state(policePagedListItemResponse.getState())
                .build();
    }
}
