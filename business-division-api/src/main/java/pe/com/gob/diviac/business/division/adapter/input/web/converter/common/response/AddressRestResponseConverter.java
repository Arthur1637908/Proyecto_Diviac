package pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.AddressRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ParameterRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.UbigeoRestResponse;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Parameter;
import pe.com.gob.diviac.business.division.entity.Ubigeo;

@Builder
@RequiredArgsConstructor
public class AddressRestResponseConverter implements Function<Address, AddressRestResponse> {

    private final Function<Parameter, ParameterRestResponse> parameterRestResponseConverter;
    private final Function<Ubigeo, UbigeoRestResponse> ubigeoRestResponseConverter;

    @Override
    public AddressRestResponse apply(Address address) {
        if (Objects.isNull(address)) {
            return null;
        }

        return AddressRestResponse.builder()
                .id(address.getId())
                .type(parameterRestResponseConverter.apply(address.getType()))
                .name(address.getName())
                .number(address.getNumber())
                .department(ubigeoRestResponseConverter.apply(address.getUbigeo()))
                .province(ubigeoRestResponseConverter.apply(address.getProvince()))
                .district(ubigeoRestResponseConverter.apply(address.getDistrict()))
                .build();
    }
}
