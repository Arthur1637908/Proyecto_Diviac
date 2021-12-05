package pe.com.gob.diviac.business.division.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.business.division.adapter.input.web.converter.common.request.AddressRestRequestConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.common.request.ContactRestRequestConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response.AddressRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response.ContactRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response.ParameterRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response.UbigeoRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.detail.response.DivisionDetailRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.list.request.DivisionsListRestRequestConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.list.response.DivisionsListItemRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.list.response.DivisionsListRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.list.response.PageRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.save.request.SaveDivisionRestRequestConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.save.response.SaveDivisionRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.update.request.UpdateDivisionRestRequestConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.converter.update.response.UpdateDivisionRestResponseConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.AddressRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.ContactRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.AddressRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ContactRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ParameterRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.UbigeoRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.detail.response.DivisionDetailRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.request.DivisionsListRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.DivisionsListItemRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.DivisionsListRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.PageRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.save.request.SaveDivisionRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.save.response.SaveDivisionRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.update.response.UpdateDivisionRestResponse;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Contact;
import pe.com.gob.diviac.business.division.entity.Division;
import pe.com.gob.diviac.business.division.entity.Parameter;
import pe.com.gob.diviac.business.division.entity.Ubigeo;
import pe.com.gob.diviac.business.division.entity.request.DivisionsListRequest;
import pe.com.gob.diviac.business.division.entity.response.DivisionsListResponse;
import pe.com.gob.diviac.business.division.entity.response.PageResponse;

@Configuration
public class ControllerConfiguration {

    /*
     * Request Converter Beans - [COMMON]
     */

    @Bean
    public Function<AddressRestRequest, Address> addressRestRequestConverter() {
        return AddressRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<ContactRestRequest, Contact> contactRestRequestConverter() {
        return ContactRestRequestConverter.builder()
                .build();
    }

    /*
     * Response Converter Beans - [COMMON]
     */

    @Bean
    public Function<Address, AddressRestResponse> addressRestResponseConverter(
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter,
            Function<Ubigeo, UbigeoRestResponse> ubigeoRestResponseConverter) {
        return AddressRestResponseConverter.builder()
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .ubigeoRestResponseConverter(ubigeoRestResponseConverter)
                .build();
    }

    @Bean
    public Function<Contact, ContactRestResponse> contactRestResponseConverter() {
        return ContactRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Parameter, ParameterRestResponse> parameterRestResponseConverter() {
        return ParameterRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Ubigeo, UbigeoRestResponse> ubigeoRestResponseConverter() {
        return UbigeoRestResponseConverter.builder()
                .build();
    }

    /*
     * Request Converter Beans - [DETAIL]
     */

    //TODO: Add request converter beans

    /*
     * Response Converter Beans - [DETAIL]
     */

    @Bean
    public Function<Division, DivisionDetailRestResponse> divisionDetailRestResponseConverter(
            Function<Address, AddressRestResponse> addressRestResponseConverter,
            Function<Contact, ContactRestResponse> contactRestResponseConverter) {
        return DivisionDetailRestResponseConverter.builder()
                .addressRestResponseConverter(addressRestResponseConverter)
                .contactRestResponseConverter(contactRestResponseConverter)
                .build();
    }

    /*
     * Request Converter Beans - [LIST]
     */

    @Bean
    public Function<DivisionsListRestRequest, DivisionsListRequest> divisionsListRestRequestConverter() {
        return DivisionsListRestRequestConverter.builder()
                .build();
    }

    /*
     * Response Converter Beans - [LIST]
     */

    @Bean
    public Function<Division, DivisionsListItemRestResponse> divisionsListItemRestResponseConverter() {
        return DivisionsListItemRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<DivisionsListResponse, DivisionsListRestResponse> divisionsListRestResponseConverter(
            Function<PageResponse, PageRestResponse> pageRestResponseConverter,
            Function<Division, DivisionsListItemRestResponse> divisionsListItemRestResponseConverter) {
        return DivisionsListRestResponseConverter.builder()
                .pageRestResponseConverter(pageRestResponseConverter)
                .divisionsListItemRestResponseConverter(divisionsListItemRestResponseConverter)
                .build();
    }

    @Bean
    public Function<PageResponse, PageRestResponse> pageRestResponseConverter() {
        return PageRestResponseConverter.builder()
                .build();
    }

    /*
     * Request Converter Beans - [SAVE]
     */

    @Bean
    public Function<SaveDivisionRestRequest, Division> saveDivisionRestRequestConverter(
            Function<AddressRestRequest, Address> addressRestRequestConverter,
            Function<ContactRestRequest, Contact> contactRestRequestConverter) {
        return SaveDivisionRestRequestConverter.builder()
                .addressRestRequestConverter(addressRestRequestConverter)
                .contactRestRequestConverter(contactRestRequestConverter)
                .build();
    }

    /*
     * Response Converter Beans - [SAVE]
     */

    @Bean
    public Function<Division, SaveDivisionRestResponse> saveDivisionRestResponseConverter(
            Function<Address, AddressRestResponse> addressRestResponseConverter,
            Function<Contact, ContactRestResponse> contactRestResponseConverter) {
        return SaveDivisionRestResponseConverter.builder()
                .addressRestResponseConverter(addressRestResponseConverter)
                .contactRestResponseConverter(contactRestResponseConverter)
                .build();
    }

    /*
     * Request Converter Beans - [UPDATE]
     */

    @Bean
    public Function<UpdateDivisionRestRequestConverter.Wrapper, Division> updateDivisionRestRequestConverter(
            Function<AddressRestRequest, Address> addressRestRequestConverter,
            Function<ContactRestRequest, Contact> contactRestRequestConverter) {
        return UpdateDivisionRestRequestConverter.builder()
                .addressRestRequestConverter(addressRestRequestConverter)
                .contactRestRequestConverter(contactRestRequestConverter)
                .build();
    }

    /*
     * Response Converter Beans - [UPDATE]
     */

    @Bean
    public Function<Division, UpdateDivisionRestResponse> updateDivisionRestResponseConverter(
            Function<Address, AddressRestResponse> updateAddressRestResponseConverter,
            Function<Contact, ContactRestResponse> updateContactRestResponseConverter) {
        return UpdateDivisionRestResponseConverter.builder()
                .updateAddressRestResponseConverter(updateAddressRestResponseConverter)
                .updateContactRestResponseConverter(updateContactRestResponseConverter)
                .build();
    }

}
