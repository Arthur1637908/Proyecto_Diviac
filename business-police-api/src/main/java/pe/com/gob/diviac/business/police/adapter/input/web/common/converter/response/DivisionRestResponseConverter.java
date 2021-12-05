package pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.entity.Division;

@Builder
public class DivisionRestResponseConverter implements Function<Division, DivisionRestResponse> {

    @Override
    public DivisionRestResponse apply(Division division) {
        if (Objects.isNull(division)) {
            return null;
        }

        return DivisionRestResponse.builder()
                .id(division.getId())
                .name(division.getName())
                .build();
    }
}
