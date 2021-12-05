package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.adapter.contract.divisionv1.AddressRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.ContactRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionRestResponseBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;
import pe.com.gob.diviac.channel.administration.entity.division.Division;

@Builder
@RequiredArgsConstructor
public class DivisionConverter implements Function<DivisionRestResponseBusiness, Division> {

    private final Function<AddressRestBusiness, Address> addressConverter;
    private final Function<ContactRestBusiness, Contact> contactConverter;

    @Override
    public Division apply(DivisionRestResponseBusiness divisionRestResponseBusiness) {
        if (divisionRestResponseBusiness != null) {
            return Division.builder()
                    .id(UUID.fromString(divisionRestResponseBusiness.getId()))
                    .code(divisionRestResponseBusiness.getCode())
                    .acronym(divisionRestResponseBusiness.getAcronym())
                    .name(divisionRestResponseBusiness.getName())
                    .description(divisionRestResponseBusiness.getDescription())
                    .address(addressConverter.apply(divisionRestResponseBusiness.getAddress()))
                    .contact(contactConverter.apply(divisionRestResponseBusiness.getContact()))
                    .build();
        }

        return null;
    }
}
