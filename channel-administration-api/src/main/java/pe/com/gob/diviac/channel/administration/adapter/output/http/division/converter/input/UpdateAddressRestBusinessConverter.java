package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.adapter.contract.divisionv1.AddressTypeRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DepartmentRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DistrictRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.ProvinceRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateAddressRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;
import pe.com.gob.diviac.channel.administration.entity.division.Department;
import pe.com.gob.diviac.channel.administration.entity.division.District;
import pe.com.gob.diviac.channel.administration.entity.division.Province;

@Builder
@RequiredArgsConstructor
public class UpdateAddressRestBusinessConverter implements Function<Address, UpdateAddressRestBusiness> {

    private final Function<AddressType, AddressTypeRestBusiness> addressTypeRestBusinessConverter;
    private final Function<District, DistrictRestBusiness> districtRestBusinessConverter;
    private final Function<Province, ProvinceRestBusiness> provinceRestBusinessConverter;
    private final Function<Department, DepartmentRestBusiness> departmentRestBusinessConverter;

    @Override
    public UpdateAddressRestBusiness apply(Address address) {
        if (address != null) {
            UpdateAddressRestBusiness updateAddressRestBusiness = new UpdateAddressRestBusiness();

            updateAddressRestBusiness.setName(address.getName());
            updateAddressRestBusiness.setNumber(address.getNumber());
            updateAddressRestBusiness.setType(addressTypeRestBusinessConverter.apply(address.getType()));
            updateAddressRestBusiness.setDistrict(districtRestBusinessConverter.apply(address.getDistrict()));

            return updateAddressRestBusiness;
        }

        return null;
    }
}