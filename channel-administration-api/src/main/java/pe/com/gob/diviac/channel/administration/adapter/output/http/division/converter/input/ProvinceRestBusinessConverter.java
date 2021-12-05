package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.ProvinceRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Province;

@Builder
public class ProvinceRestBusinessConverter implements Function<Province, ProvinceRestBusiness> {

    @Override
    public ProvinceRestBusiness apply(Province province) {
        if (province != null) {
            ProvinceRestBusiness provinceRestBusiness = new ProvinceRestBusiness();

            provinceRestBusiness.setId(province.getId());
            provinceRestBusiness.setName(province.getName());

            return provinceRestBusiness;
        }

        return null;
    }
}
