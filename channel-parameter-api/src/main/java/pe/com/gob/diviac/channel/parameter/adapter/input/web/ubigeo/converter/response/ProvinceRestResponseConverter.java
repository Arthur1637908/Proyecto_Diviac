package pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.converter.response;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response.ProvinceRestResponse;
import pe.com.gob.diviac.channel.parameter.entity.Province;

@Builder
public class ProvinceRestResponseConverter implements Function<Province, ProvinceRestResponse> {

    @Override
    public ProvinceRestResponse apply(Province province) {
        if (province != null) {
            return ProvinceRestResponse.builder()
                    .id(province.getId())
                    .name(province.getName())
                    .build();
        }

        return null;
    }

}
