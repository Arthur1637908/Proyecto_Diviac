package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.response.detail;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.ContactDetailRestResponse;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;

@Builder
public class ContactDetailRestResponseConverter implements Function<Contact, ContactDetailRestResponse> {

    @Override
    public ContactDetailRestResponse apply(Contact contact) {
        if (contact != null) {
            return ContactDetailRestResponse.builder()
                    .email(contact.getEmail())
                    .phoneNumber(contact.getPhoneNumber())
                    .annexNumber(contact.getAnnexNumber())
                    .build();
        }
        return null;
    }
}
