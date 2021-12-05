package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.detail;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.AddressDetailRestResponse;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;
import pe.com.gob.diviac.channel.administration.entity.division.Department;
import pe.com.gob.diviac.channel.administration.entity.division.District;
import pe.com.gob.diviac.channel.administration.entity.division.Province;

@Builder
@RequiredArgsConstructor
public class AddressDetailRestResponseConverter implements Function<Address, AddressDetailRestResponse> {

    @Override
    public AddressDetailRestResponse apply(Address address) {
        if (address != null) {
            return AddressDetailRestResponse.builder()
                    .id(address.getId())
                    .name(address.getName())
                    .number(address.getNumber())
                    .typeId(this.getTypeId(address.getType()))
                    .districtId(this.getDistrictId(address.getDistrict()))
                    .provinceId(this.getProvinceId(address.getProvince()))
                    .departmentId(this.getDepartmentId(address.getDepartment()))
                    .build();
        }

        return null;
    }

    public Integer getTypeId(AddressType addressType) {
        if (addressType != null) {
            return addressType.getId();
        }

        return null;
    }

    public Integer getDistrictId(District district) {
        if (district != null) {
            return district.getId();
        }

        return null;
    }

    public Integer getProvinceId(Province province) {
        if (province != null) {
            return province.getId();
        }

        return null;
    }

    public Integer getDepartmentId(Department department) {
        if (department != null) {
            return department.getId();
        }

        return null;
    }
}
