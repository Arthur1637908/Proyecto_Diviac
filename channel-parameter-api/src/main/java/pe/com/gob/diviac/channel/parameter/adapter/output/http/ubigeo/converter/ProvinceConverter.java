package pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo.converter;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.parameterv1.ProvinceBusinessResponse;
import pe.com.gob.diviac.channel.parameter.entity.Province;

@Builder
public class ProvinceConverter
        implements Function<ProvinceBusinessResponse, Province> {

    @Override
    public Province apply(ProvinceBusinessResponse provinceBusinessResponse) {
        if (provinceBusinessResponse != null) {
            return Province.builder()
                    .id(provinceBusinessResponse.getId())
                    .name(provinceBusinessResponse.getName())
                    .build();
        }

        return null;
    }
}
