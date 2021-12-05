package pe.com.gob.diviac.business.division.adapter.input.web.converter.detail.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.AddressRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ContactRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.detail.response.DivisionDetailRestResponse;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Contact;
import pe.com.gob.diviac.business.division.entity.Division;

@Builder
@RequiredArgsConstructor
public class DivisionDetailRestResponseConverter implements Function<Division, DivisionDetailRestResponse> {

    private final Function<Address, AddressRestResponse> addressRestResponseConverter;
    private final Function<Contact, ContactRestResponse> contactRestResponseConverter;

    @Override
    public DivisionDetailRestResponse apply(Division division) {
        if (Objects.isNull(division)) {
            return null;
        }

        return DivisionDetailRestResponse.builder()
                .id(division.getId())
                .code(division.getCode())
                .acronym(division.getAcronym())
                .name(division.getName())
                .description(division.getDescription())
                .address(addressRestResponseConverter.apply(division.getAddress()))
                .contact(contactRestResponseConverter.apply(division.getContact()))
                .build();
    }
}
