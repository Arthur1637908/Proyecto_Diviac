package pe.com.gob.diviac.business.division.adapter.input.web.converter.common.request;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.ContactRestRequest;
import pe.com.gob.diviac.business.division.entity.Contact;

@Builder
public class ContactRestRequestConverter implements Function<ContactRestRequest, Contact> {

    @Override
    public Contact apply(ContactRestRequest contactRestRequest) {
        if (Objects.isNull(contactRestRequest)) {
            return null;
        }

        return Contact.builder()
                .email(contactRestRequest.getEmail())
                .phoneNumber(contactRestRequest.getPhoneNumber())
                .annexNumber(contactRestRequest.getAnnexNumber())
                .build();
    }
}
