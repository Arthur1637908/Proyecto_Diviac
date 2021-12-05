package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.ProvinceRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Province;

@Builder
public class ProvinceConverter implements Function<ProvinceRestBusiness, Province> {

    @Override
    public Province apply(ProvinceRestBusiness provinceRestBusiness) {
        if (provinceRestBusiness != null) {
            return Province.builder()
                    .id(provinceRestBusiness.getId())
                    .name(provinceRestBusiness.getName())
                    .build();
        }

        return null;
    }
}
