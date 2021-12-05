package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.detail;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.AddressDetailRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.ContactDetailRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.DivisionDetailRestResponse;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;
import pe.com.gob.diviac.channel.administration.entity.division.Division;

@Builder
@RequiredArgsConstructor
public class DivisionDetailRestResponseConverter implements Function<Division, DivisionDetailRestResponse> {

    private final Function<Address, AddressDetailRestResponse> addressDetailRestResponseConverter;
    private final Function<Contact, ContactDetailRestResponse> contactDetailRestResponseConverter;

    @Override
    public DivisionDetailRestResponse apply(Division division) {
        if (division != null) {
            return DivisionDetailRestResponse.builder()
                    .id(String.valueOf(division.getId()))
                    .code(division.getCode())
                    .acronym(division.getAcronym())
                    .name(division.getName())
                    .description(division.getDescription())
                    .address(addressDetailRestResponseConverter.apply(division.getAddress()))
                    .contact(contactDetailRestResponseConverter.apply(division.getContact()))
                    .build();
        }

        return null;
    }
}
