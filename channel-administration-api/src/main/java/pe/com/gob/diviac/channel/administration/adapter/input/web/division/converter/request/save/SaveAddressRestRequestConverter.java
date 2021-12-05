package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.save;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveAddressRestRequest;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;
import pe.com.gob.diviac.channel.administration.entity.division.District;

@Builder
@RequiredArgsConstructor
public class SaveAddressRestRequestConverter implements Function<SaveAddressRestRequest, Address> {

    @Override
    public Address apply(SaveAddressRestRequest saveAddressRestRequest) {
        if (saveAddressRestRequest != null) {
            return Address.builder()
                    .name(saveAddressRestRequest.getName())
                    .number(saveAddressRestRequest.getNumber())
                    .type(this.setType(saveAddressRestRequest))
                    .district(this.setDistrict(saveAddressRestRequest))
                    .build();
        }

        return null;
    }

    private AddressType setType(SaveAddressRestRequest saveAddressRestRequest) {
        return AddressType.builder()
                .id(saveAddressRestRequest.getTypeId())
                .build();
    }

    private District setDistrict(SaveAddressRestRequest saveAddressRestRequest) {
        return District.builder()
                .id(saveAddressRestRequest.getDistrictId())
                .build();
    }
}
