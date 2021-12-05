package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.divisionv1.ContactRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;

@Builder
public class ContactConverter implements Function<ContactRestBusiness, Contact> {

    @Override
    public Contact apply(ContactRestBusiness contactRestBusiness) {
        if (contactRestBusiness != null) {
            return Contact.builder()
                    .email(contactRestBusiness.getEmail())
                    .phoneNumber(contactRestBusiness.getPhoneNumber())
                    .annexNumber(contactRestBusiness.getAnnexNumber())
                    .build();
        }

        return null;
    }
}
