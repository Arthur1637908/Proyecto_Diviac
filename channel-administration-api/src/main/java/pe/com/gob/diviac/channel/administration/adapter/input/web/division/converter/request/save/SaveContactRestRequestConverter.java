package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.save;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveContactRestRequest;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;

@Builder
public class SaveContactRestRequestConverter implements Function<SaveContactRestRequest, Contact> {

    @Override
    public Contact apply(SaveContactRestRequest saveContactRestRequest) {
        if (saveContactRestRequest != null) {
            return Contact.builder()
                    .email(saveContactRestRequest.getEmail())
                    .phoneNumber(saveContactRestRequest.getPhoneNumber())
                    .annexNumber(saveContactRestRequest.getAnnexNumber())
                    .build();
        }

        return null;
    }
}
