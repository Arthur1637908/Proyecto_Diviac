package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.entity.Division;

@Builder
public class DivisionEntityConverter implements Function<Division, DivisionEntity> {

    @Override
    public DivisionEntity apply(Division division) {
        if (Objects.isNull(division)) {
            return null;
        }

        DivisionEntity divisionEntity = new DivisionEntity();

        divisionEntity.setId(division.getId());
        divisionEntity.setName(division.getName());

        return divisionEntity;
    }
}
