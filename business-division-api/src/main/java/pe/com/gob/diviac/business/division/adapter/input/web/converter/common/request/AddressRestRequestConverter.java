package pe.com.gob.diviac.business.division.adapter.input.web.converter.common.request;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.AddressRestRequest;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Parameter;
import pe.com.gob.diviac.business.division.entity.Ubigeo;

@Builder
public class AddressRestRequestConverter implements Function<AddressRestRequest, Address> {

    @Override
    public Address apply(AddressRestRequest addressRestRequest) {
        if (Objects.isNull(addressRestRequest)) {
            return null;
        }

        return Address.builder()
                .name(addressRestRequest.getName())
                .number(addressRestRequest.getNumber())
                .type(this.getAddressType(addressRestRequest.getTypeId()))
                .district(this.getUbigeo(addressRestRequest.getDistrictId()))
                .build();
    }

    private Parameter getAddressType(Integer addressTypeId) {
        if (Objects.isNull(addressTypeId)) {
            return null;
        }

        return Parameter.builder()
                .id(addressTypeId)
                .build();
    }

    private Ubigeo getUbigeo(Integer ubigeoId) {
        if (Objects.isNull(ubigeoId)) {
            return null;
        }

        return Ubigeo.builder()
                .id(ubigeoId)
                .build();
    }
}
