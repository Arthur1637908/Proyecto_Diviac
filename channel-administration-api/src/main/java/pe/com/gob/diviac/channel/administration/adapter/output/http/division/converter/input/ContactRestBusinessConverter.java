package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.divisionv1.ContactRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;

@Builder
public class ContactRestBusinessConverter implements Function<Contact, ContactRestBusiness> {

    @Override
    public ContactRestBusiness apply(Contact contact) {
        if (contact != null) {
            ContactRestBusiness contactRestBusiness = new ContactRestBusiness();

            contactRestBusiness.setEmail(contact.getEmail());
            contactRestBusiness.setPhoneNumber(contact.getPhoneNumber());
            contactRestBusiness.setAnnexNumber(contact.getAnnexNumber());

            return contactRestBusiness;
        }

        return null;
    }
}
