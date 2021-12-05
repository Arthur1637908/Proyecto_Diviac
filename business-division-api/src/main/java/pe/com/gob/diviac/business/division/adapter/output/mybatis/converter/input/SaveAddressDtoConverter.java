package pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveAddressDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveDivisionDto;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Division;

@Builder
public class SaveAddressDtoConverter
        implements Function<Address, SaveAddressDto> {

    @Override
    public SaveAddressDto apply(Address address) {

        if (address != null) {
            return SaveAddressDto.builder()
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
