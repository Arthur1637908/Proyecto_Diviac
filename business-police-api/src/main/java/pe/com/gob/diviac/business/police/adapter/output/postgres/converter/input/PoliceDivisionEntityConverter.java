package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.Data;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceDivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;

@Builder
public class PoliceDivisionEntityConverter
        implements Function<PoliceDivisionEntityConverter.Wrapper, PoliceDivisionEntity> {

    @Override
    public PoliceDivisionEntity apply(PoliceDivisionEntityConverter.Wrapper wrapper) {
        if (Objects.isNull(wrapper)) {
            return null;
        }

        PoliceDivisionEntity policeDivisionEntity = new PoliceDivisionEntity();

        policeDivisionEntity.setPolice(wrapper.getPoliceEntity());
        policeDivisionEntity.setDivision(wrapper.getDivisionEntity());
        policeDivisionEntity.setState(Boolean.TRUE);

        //TODO: Implement audit logic
        policeDivisionEntity.setCreationUserId(String.valueOf(UUID.randomUUID()));
        policeDivisionEntity.setCreationUserRoleId(1);

        return policeDivisionEntity;
    }

    @Data
    @Builder
    public static class Wrapper {

        private PoliceEntity policeEntity;
        private DivisionEntity divisionEntity;
    }
}
