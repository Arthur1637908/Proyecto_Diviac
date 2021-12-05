package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;


import pe.com.gob.diviac.adapter.contract.divisionv1.AddressRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.AddressTypeRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DepartmentRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DistrictRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.ProvinceRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.Department;
import pe.com.gob.diviac.channel.administration.entity.division.District;
import pe.com.gob.diviac.channel.administration.entity.division.Province;

@Builder
@RequiredArgsConstructor
public class AddressConverter implements Function<AddressRestBusiness, Address> {

    private final Function<DepartmentRestBusiness, Department> departmentConverter;
    private final Function<ProvinceRestBusiness, Province> provinceConverter;
    private final Function<DistrictRestBusiness, District> districtConverter;
    private final Function<AddressTypeRestBusiness, AddressType> addressTypeConverter;

    @Override
    public Address apply(AddressRestBusiness addressRestBusiness) {
        if (addressRestBusiness != null) {
            return Address.builder()
                    .id(addressRestBusiness.getId())
                    .department(departmentConverter.apply(addressRestBusiness.getDepartment()))
                    .province(provinceConverter.apply(addressRestBusiness.getProvince()))
                    .district(districtConverter.apply(addressRestBusiness.getDistrict()))
                    .type(addressTypeConverter.apply(addressRestBusiness.getType()))
                    .name(addressRestBusiness.getName())
                    .number(addressRestBusiness.getNumber())
                    .build();
        }

        return null;
    }
}
