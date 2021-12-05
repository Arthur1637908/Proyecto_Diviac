package pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.converter.response;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.model.response.DistrictRestResponse;
import pe.com.gob.diviac.business.parameter.entity.District;

@Builder
public class DistrictRestResponseConverter implements Function<District, DistrictRestResponse> {

    @Override
    public DistrictRestResponse apply(District district) {
        if (district != null) {
            return DistrictRestResponse.builder()
                    .id(district.getId())
                    .name(district.getName())
                    .build();
        }

        return null;
    }

}
