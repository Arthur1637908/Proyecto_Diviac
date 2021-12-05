package pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output;

import lombok.Builder;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DistrictEntity;
import pe.com.gob.diviac.business.parameter.entity.District;

import java.util.function.Function;

@Builder
public class DistrictConverter implements Function<DistrictEntity, District> {

    @Override
    public District apply(DistrictEntity districtEntity) {
        if (districtEntity != null) {
            return District.builder()
                    .id(districtEntity.getIntIdDistrito())
                    .name(districtEntity.getVchNombreDistrito())
                    .build();
        }

        return null;
    }
}
