package pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo.converter;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.parameterv1.DistrictBusinessResponse;
import pe.com.gob.diviac.channel.parameter.entity.District;

@Builder
public class DistrictConverter
        implements Function<DistrictBusinessResponse, District> {

    @Override
    public District apply(DistrictBusinessResponse districtBusinessResponse) {
        if (districtBusinessResponse != null) {
            return District.builder()
                    .id(districtBusinessResponse.getId())
                    .name(districtBusinessResponse.getName())
                    .build();
        }

        return null;
    }
}
