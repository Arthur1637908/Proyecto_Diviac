package pe.com.gob.diviac.channel.administration.application.usecase.division;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.adapter.contract.divisionv1.AddressRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.AddressTypeRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.ContactRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DepartmentRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DistrictRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionListRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.PageRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.ProvinceRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveAddressRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveDivisionRestRequestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateAddressRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateDivisionRestRequestBusiness;
import pe.com.gob.diviac.channel.administration.adapter.input.web.common.converter.response.PageRestResponseConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.list.DivisionListRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.save.SaveAddressRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.save.SaveContactRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.save.SaveDivisionRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.update.UpdateAddressRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.update.UpdateContactRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.update.UpdateDivisionRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.detail.AddressDetailRestResponseConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.detail.ContactDetailRestResponseConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.list.DivisionListRestResponseConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.detail.DivisionDetailRestResponseConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.update.UpdateDivisionRestResponseConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.list.DivisionListRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveAddressRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveContactRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveDivisionRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateAddressRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateContactRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateDivisionRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.AddressDetailRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.ContactDetailRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.list.DivisionListRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.DivisionDetailRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.update.UpdateDivisionRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.output.http.common.converter.output.PageResponseConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.AddressTypeRestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.ContactRestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.DepartmentRestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.DistrictRestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.ProvinceRestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.SaveAddressRestRequestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.SaveDivisionRestRequestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.UpdateAddressRestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input.UpdateDivisionRestRequestBusinessConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.AddressConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.AddressTypeConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.ContactConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.DepartmentConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.DistrictConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.DivisionConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.ProvinceConverter;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output.DivisionListResponseConverter;
import pe.com.gob.diviac.channel.administration.entity.common.response.PageResponse;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.AddressType;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;
import pe.com.gob.diviac.channel.administration.entity.division.Department;
import pe.com.gob.diviac.channel.administration.entity.division.District;
import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.Province;
import pe.com.gob.diviac.channel.administration.entity.division.request.DivisionListRequest;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

@Configuration
public class ConverterConfiguration {

    /**
     * Http Client Output Converter - [COMMON]
     */

    @Bean
    public Function<PageRestBusiness, PageResponse> pageResponseConverter() {
        return PageResponseConverter.builder()
                .build();
    }


    /**
     * Http Client Input Converter - [DIVISION]
     */

    @Bean
    public Function<AddressType, AddressTypeRestBusiness> addressTypeRestBusinessConverter() {
        return AddressTypeRestBusinessConverter.builder()
                .build();
    }

    @Bean
    public Function<Contact, ContactRestBusiness> contactRestBusinessConverter() {
        return ContactRestBusinessConverter.builder()
                .build();
    }

    @Bean
    public Function<Department, DepartmentRestBusiness> departmentRestBusinessConverter() {
        return DepartmentRestBusinessConverter.builder()
                .build();
    }

    @Bean
    public Function<District, DistrictRestBusiness> districtRestBusinessConverter() {
        return DistrictRestBusinessConverter.builder()
                .build();
    }

    @Bean
    public Function<Province, ProvinceRestBusiness> provinceRestBusinessConverter() {
        return ProvinceRestBusinessConverter.builder()
                .build();
    }

    @Bean
    public Function<Address, SaveAddressRestBusiness> saveAddressRestRequestBusinessConverter(
            Function<AddressType, AddressTypeRestBusiness> addressTypeRestBusinessConverter,
            Function<District, DistrictRestBusiness> districtRestBusinessConverter,
            Function<Province, ProvinceRestBusiness> provinceRestBusinessConverter,
            Function<Department, DepartmentRestBusiness> departmentRestBusinessConverter) {
        return SaveAddressRestRequestBusinessConverter.builder()
                .addressTypeRestBusinessConverter(addressTypeRestBusinessConverter)
                .districtRestBusinessConverter(districtRestBusinessConverter)
                .provinceRestBusinessConverter(provinceRestBusinessConverter)
                .departmentRestBusinessConverter(departmentRestBusinessConverter)
                .build();
    }

    @Bean
    public Function<Division, SaveDivisionRestRequestBusiness> saveDivisionRestRequestBusinessConverter(
            Function<Address, SaveAddressRestBusiness> saveAddressRestBusinessConverter,
            Function<Contact, ContactRestBusiness> contactRestBusinessConverter) {
        return SaveDivisionRestRequestBusinessConverter.builder()
                .saveAddressRestBusinessConverter(saveAddressRestBusinessConverter)
                .contactRestBusinessConverter(contactRestBusinessConverter)
                .build();
    }

    @Bean
    public Function<Address, UpdateAddressRestBusiness> updateAddressRestBusinessConverter(
            Function<AddressType, AddressTypeRestBusiness> addressTypeRestBusinessConverter,
            Function<District, DistrictRestBusiness> districtRestBusinessConverter,
            Function<Province, ProvinceRestBusiness> provinceRestBusinessConverter,
            Function<Department, DepartmentRestBusiness> departmentRestBusinessConverter) {
        return UpdateAddressRestBusinessConverter.builder()
                .addressTypeRestBusinessConverter(addressTypeRestBusinessConverter)
                .districtRestBusinessConverter(districtRestBusinessConverter)
                .provinceRestBusinessConverter(provinceRestBusinessConverter)
                .departmentRestBusinessConverter(departmentRestBusinessConverter)
                .build();
    }

    @Bean
    public Function<Division, UpdateDivisionRestRequestBusiness> updateDivisionRestRequestBusinessConverter(
            Function<Address, UpdateAddressRestBusiness> updateAddressRestBusinessConverter,
            Function<Contact, ContactRestBusiness> contactRestBusinessConverter) {
        return UpdateDivisionRestRequestBusinessConverter.builder()
                .updateAddressRestBusinessConverter(updateAddressRestBusinessConverter)
                .contactRestBusinessConverter(contactRestBusinessConverter)
                .build();
    }


    /**
     * Http Client Output Converter - [DIVISION]
     */

    @Bean
    public Function<AddressRestBusiness, Address> addressConverter(
            Function<DepartmentRestBusiness, Department> departmentConverter,
            Function<ProvinceRestBusiness, Province> provinceConverter,
            Function<DistrictRestBusiness, District> districtConverter,
            Function<AddressTypeRestBusiness, AddressType> addressTypeConverter) {
        return AddressConverter.builder()
                .departmentConverter(departmentConverter)
                .provinceConverter(provinceConverter)
                .districtConverter(districtConverter)
                .addressTypeConverter(addressTypeConverter)
                .build();
    }

    @Bean
    public Function<AddressTypeRestBusiness, AddressType> addressTypeConverter() {
        return AddressTypeConverter.builder()
                .build();
    }

    @Bean
    public Function<ContactRestBusiness, Contact> contactConverter() {
        return ContactConverter.builder()
                .build();
    }

    @Bean
    public Function<DepartmentRestBusiness, Department> departmentConverter() {
        return DepartmentConverter.builder()
                .build();
    }

    @Bean
    public Function<DistrictRestBusiness, District> districtConverter() {
        return DistrictConverter.builder()
                .build();
    }

    @Bean
    public Function<DivisionRestResponseBusiness, Division> divisionConverter(
            Function<AddressRestBusiness, Address> addressConverter,
            Function<ContactRestBusiness, Contact> contactConverter) {
        return DivisionConverter.builder()
                .addressConverter(addressConverter)
                .contactConverter(contactConverter)
                .build();
    }

    @Bean
    public Function<DivisionListRestResponseBusiness, DivisionListResponse> divisionListResponseConverter(
            Function<PageRestBusiness, PageResponse> pageResponseConverter,
            Function<DivisionRestResponseBusiness, Division> divisionConverter) {
        return DivisionListResponseConverter.builder()
                .pageResponseConverter(pageResponseConverter)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public Function<ProvinceRestBusiness, Province> provinceConverter() {
        return ProvinceConverter.builder()
                .build();
    }


    /**
     * Controller Response Converter - [COMMON]
     */

    @Bean
    public Function<PageResponse, PageRestResponse> pageRestResponseConverter() {
        return PageRestResponseConverter.builder()
                .build();
    }


    /**
     * Controller Request Converter - [DIVISION]
     */

    @Bean
    public Function<DivisionListRestRequest, DivisionListRequest> divisionListRestRequestConverter() {
        return DivisionListRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<SaveAddressRestRequest, Address> saveAddressRestRequestConverter() {
        return SaveAddressRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<SaveContactRestRequest, Contact> saveContactRestRequestConverter() {
        return SaveContactRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<SaveDivisionRestRequest, Division> saveDivisionRestRequestConverter(
            Function<SaveAddressRestRequest, Address> saveAddressRestRequestConverter,
            Function<SaveContactRestRequest, Contact> saveContactRestRequestConverter) {
        return SaveDivisionRestRequestConverter.builder()
                .saveAddressRestRequestConverter(saveAddressRestRequestConverter)
                .saveContactRestRequestConverter(saveContactRestRequestConverter)
                .build();
    }

    @Bean
    public Function<UpdateAddressRestRequest, Address> updateAddressRestRequestConverter() {
        return UpdateAddressRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<UpdateContactRestRequest, Contact> updateContactRestRequestConverter() {
        return UpdateContactRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<UpdateDivisionRestRequestConverter.Wrapper, Division> updateDivisionRestRequestConverter(
            Function<UpdateAddressRestRequest, Address> updateAddressRestRequestConverter,
            Function<UpdateContactRestRequest, Contact> updateContactRestRequestConverter) {
        return UpdateDivisionRestRequestConverter.builder()
                .updateAddressRestRequestConverter(updateAddressRestRequestConverter)
                .updateContactRestRequestConverter(updateContactRestRequestConverter)
                .build();
    }


    /**
     * Controller Response Converter - [DIVISION]
     */

    @Bean
    public Function<Address, AddressDetailRestResponse> addressDetailRestResponseConverter() {
        return AddressDetailRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Contact, ContactDetailRestResponse> contactDetailRestResponseConverter() {
        return ContactDetailRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Division, DivisionDetailRestResponse> divisionDetailRestResponseConverter(
            Function<Address, AddressDetailRestResponse> addressDetailRestResponseConverter,
            Function<Contact, ContactDetailRestResponse> contactDetailRestResponseConverter) {
        return DivisionDetailRestResponseConverter.builder()
                .addressDetailRestResponseConverter(addressDetailRestResponseConverter)
                .contactDetailRestResponseConverter(contactDetailRestResponseConverter)
                .build();
    }

    @Bean
    public Function<DivisionListResponse, DivisionListRestResponse> divisionListRestResponseConverter(
            Function<PageResponse, PageRestResponse> pageRestResponseConverter,
            Function<Division, DivisionDetailRestResponse> divisionDetailRestResponseConverter) {
        return DivisionListRestResponseConverter.builder()
                .pageRestResponseConverter(pageRestResponseConverter)
                .divisionDetailRestResponseConverter(divisionDetailRestResponseConverter)
                .build();
    }

    @Bean
    public Function<Division, UpdateDivisionRestResponse> updateDivisionRestResponseConverter(
            Function<Address, AddressDetailRestResponse> addressDetailRestResponseConverter,
            Function<Contact, ContactDetailRestResponse> contactDetailRestResponseConverter) {
        return UpdateDivisionRestResponseConverter.builder()
                .addressDetailRestResponseConverter(addressDetailRestResponseConverter)
                .contactDetailRestResponseConverter(contactDetailRestResponseConverter)
                .build();
    }

}
