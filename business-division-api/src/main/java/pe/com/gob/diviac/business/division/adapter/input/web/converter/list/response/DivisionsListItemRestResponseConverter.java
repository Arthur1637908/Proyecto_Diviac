package pe.com.gob.diviac.business.division.adapter.input.web.converter.list.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.DivisionsListItemRestResponse;
import pe.com.gob.diviac.business.division.entity.Division;

@Builder
public class DivisionsListItemRestResponseConverter implements Function<Division, DivisionsListItemRestResponse> {

    @Override
    public DivisionsListItemRestResponse apply(Division division) {
        if (Objects.isNull(division)) {
            return null;
        }

        return DivisionsListItemRestResponse.builder()
                .id(division.getId())
                .code(division.getCode())
                .name(division.getName())
                .acronym(division.getAcronym())
                .description(division.getDescription())
                .build();
    }
}
