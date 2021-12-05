package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.entity.Division;

@Builder
public class DivisionConverter implements Function<DivisionEntity, Division> {

    @Override
    public Division apply(DivisionEntity divisionEntity) {
        if (Objects.isNull(divisionEntity)) {
            return null;
        }

        return Division.builder()
                .id(divisionEntity.getId())
                .name(divisionEntity.getName())
                .build();
    }
}
