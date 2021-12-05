package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.AddressTypeRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;

@Builder
public class AddressTypeConverter implements Function<AddressTypeRestBusiness, AddressType> {

    @Override
    public AddressType apply(AddressTypeRestBusiness addressTypeRestBusiness) {
        if (addressTypeRestBusiness != null) {
            return AddressType.builder()
                    .id(addressTypeRestBusiness.getId())
                    .name(addressTypeRestBusiness.getName())
                    .build();
        }

        return null;
    }
}
