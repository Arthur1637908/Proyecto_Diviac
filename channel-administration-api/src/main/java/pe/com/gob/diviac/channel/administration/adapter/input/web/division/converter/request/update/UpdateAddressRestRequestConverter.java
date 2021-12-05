package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.update;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateAddressRestRequest;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;
import pe.com.gob.diviac.channel.administration.entity.division.Department;
import pe.com.gob.diviac.channel.administration.entity.division.District;
import pe.com.gob.diviac.channel.administration.entity.division.Province;

@Builder
public class UpdateAddressRestRequestConverter implements Function<UpdateAddressRestRequest, Address> {

    @Override
    public Address apply(UpdateAddressRestRequest updateAddressRestRequest) {
        if (updateAddressRestRequest != null) {
            return Address.builder()
                    .name(updateAddressRestRequest.getName())
                    .number(updateAddressRestRequest.getNumber())
                    .type(this.setType(updateAddressRestRequest))
                    .district(this.setDistrict(updateAddressRestRequest))
                    .build();
        }

        return null;
    }

    private AddressType setType(UpdateAddressRestRequest updateAddressRestRequest) {
        return AddressType.builder()
                .id(updateAddressRestRequest.getTypeId())
                .build();
    }

    private District setDistrict(UpdateAddressRestRequest updateAddressRestRequest) {
        return District.builder()
                .id(updateAddressRestRequest.getDistrictId())
                .build();
    }
}
