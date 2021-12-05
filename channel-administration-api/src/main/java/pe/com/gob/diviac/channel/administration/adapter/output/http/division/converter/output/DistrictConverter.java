package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.DistrictRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.District;

@Builder
public class DistrictConverter implements Function<DistrictRestBusiness, District> {

    @Override
    public District apply(DistrictRestBusiness districtRestBusiness) {
        if (districtRestBusiness != null) {
            return District.builder()
                    .id(districtRestBusiness.getId())
                    .name(districtRestBusiness.getName())
                    .build();
        }

        return null;
    }
}
