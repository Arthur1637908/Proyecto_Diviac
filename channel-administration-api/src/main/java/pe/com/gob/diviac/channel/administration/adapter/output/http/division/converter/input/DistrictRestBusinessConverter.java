package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.DistrictRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.District;

@Builder
public class DistrictRestBusinessConverter implements Function<District, DistrictRestBusiness> {

    @Override
    public DistrictRestBusiness apply(District district) {
        if (district != null) {
            DistrictRestBusiness districtRestBusiness = new DistrictRestBusiness();

            districtRestBusiness.setId(district.getId());
            districtRestBusiness.setName(district.getName());

            return districtRestBusiness;
        }

        return null;
    }
}
