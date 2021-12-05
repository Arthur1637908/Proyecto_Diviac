package pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output;

import lombok.Builder;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ProvinceEntity;
import pe.com.gob.diviac.business.parameter.entity.Province;

import java.util.function.Function;

@Builder
public class ProvinceConverter implements Function<ProvinceEntity, Province> {

    @Override
    public Province apply(ProvinceEntity provinceEntity) {
        if (provinceEntity != null) {
            return Province.builder()
                    .id(provinceEntity.getIntIdProvincia())
                    .name(provinceEntity.getVchNombreProvincia())
                    .build();
        }

        return null;

    }
}
