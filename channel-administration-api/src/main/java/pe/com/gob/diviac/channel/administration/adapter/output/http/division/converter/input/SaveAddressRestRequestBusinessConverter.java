package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.divisionv1.AddressTypeRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DepartmentRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DistrictRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.ProvinceRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveAddressRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;
import pe.com.gob.diviac.channel.administration.entity.division.Department;
import pe.com.gob.diviac.channel.administration.entity.division.District;
import pe.com.gob.diviac.channel.administration.entity.division.Province;

@Builder
public class SaveAddressRestRequestBusinessConverter implements Function<Address, SaveAddressRestBusiness> {

    private final Function<AddressType, AddressTypeRestBusiness> addressTypeRestBusinessConverter;
    private final Function<District, DistrictRestBusiness> districtRestBusinessConverter;
    private final Function<Province, ProvinceRestBusiness> provinceRestBusinessConverter;
    private final Function<Department, DepartmentRestBusiness> departmentRestBusinessConverter;

    @Override
    public SaveAddressRestBusiness apply(Address address) {
        if (address != null) {
            SaveAddressRestBusiness saveAddressRestBusiness = new SaveAddressRestBusiness();

            saveAddressRestBusiness.setName(address.getName());
            saveAddressRestBusiness.setNumber(address.getNumber());
            saveAddressRestBusiness.setType(addressTypeRestBusinessConverter.apply(address.getType()));
            saveAddressRestBusiness.setDistrict(districtRestBusinessConverter.apply(address.getDistrict()));

            return saveAddressRestBusiness;
        }

        return null;
    }
}
