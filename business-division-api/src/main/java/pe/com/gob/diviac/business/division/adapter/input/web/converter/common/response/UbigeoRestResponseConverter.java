package pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response;

import lombok.Builder;

import java.util.Objects;
import java.util.function.Function;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.UbigeoRestResponse;
import pe.com.gob.diviac.business.division.entity.Ubigeo;

@Builder
public class UbigeoRestResponseConverter implements Function<Ubigeo, UbigeoRestResponse> {

    @Override
    public UbigeoRestResponse apply(Ubigeo ubigeo) {
        if (Objects.isNull(ubigeo)) {
            return null;
        }

        return UbigeoRestResponse.builder()
                .id(ubigeo.getId())
                .name(ubigeo.getName())
                .build();
    }
}
