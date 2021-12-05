package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.AddressTypeRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;

@Builder
public class AddressTypeRestBusinessConverter implements Function<AddressType, AddressTypeRestBusiness> {

    @Override
    public AddressTypeRestBusiness apply(AddressType addressType) {
        if (addressType != null) {
            AddressTypeRestBusiness addressTypeRestBusiness = new AddressTypeRestBusiness();

            addressTypeRestBusiness.setId(addressType.getId());
            addressTypeRestBusiness.setName(addressType.getName());

            return addressTypeRestBusiness;
        }

        return null;
    }
}
