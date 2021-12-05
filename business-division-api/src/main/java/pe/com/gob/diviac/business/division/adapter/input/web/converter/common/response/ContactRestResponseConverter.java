package pe.com.gob.diviac.business.division.adapter.input.web.converter.common.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ContactRestResponse;
import pe.com.gob.diviac.business.division.entity.Contact;

@Builder
public class ContactRestResponseConverter implements Function<Contact, ContactRestResponse> {

    @Override
    public ContactRestResponse apply(Contact contact) {
        if (Objects.isNull(contact)) {
            return null;
        }

        return ContactRestResponse.builder()
                .email(contact.getEmail())
                .phoneNumber(contact.getPhoneNumber())
                .annexNumber(contact.getAnnexNumber())
                .build();
    }
}
