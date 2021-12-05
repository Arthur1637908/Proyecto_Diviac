package pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input;

import lombok.Builder;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateAddressDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateDivisionDto;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Division;

import java.util.function.Function;

@Builder
public class UpdateAddressDtoConverter
        implements Function<Address, UpdateAddressDto> {

    @Override
    public UpdateAddressDto apply(Address address) {

        if (address != null) {
            return UpdateAddressDto.builder()
                    .id(address.getId())
                    .name(address.getName())
                    .number(address.getNumber())
                    .directionTypeId(address.getType().getId())
                    .districtId(address.getDistrict().getId())
                    .build();
        }

        return null;
    }

}
