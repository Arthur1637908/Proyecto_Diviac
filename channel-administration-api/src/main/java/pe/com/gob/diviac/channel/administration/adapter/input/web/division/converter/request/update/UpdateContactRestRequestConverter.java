package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.update;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateContactRestRequest;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;

@Builder
public class UpdateContactRestRequestConverter implements Function<UpdateContactRestRequest, Contact> {

    @Override
    public Contact apply(UpdateContactRestRequest updateContactRestRequest) {
        if (updateContactRestRequest != null) {
            return Contact.builder()
                    .email(updateContactRestRequest.getEmail())
                    .phoneNumber(updateContactRestRequest.getPhoneNumber())
                    .annexNumber(updateContactRestRequest.getAnnexNumber())
                    .build();
        }

        return null;
    }
}
