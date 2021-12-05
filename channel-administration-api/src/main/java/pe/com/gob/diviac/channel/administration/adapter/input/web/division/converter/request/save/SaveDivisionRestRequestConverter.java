package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.save;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveAddressRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveContactRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveDivisionRestRequest;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;
import pe.com.gob.diviac.channel.administration.entity.division.Division;

@Builder
@RequiredArgsConstructor
public class SaveDivisionRestRequestConverter implements Function<SaveDivisionRestRequest, Division> {

    private final Function<SaveAddressRestRequest, Address> saveAddressRestRequestConverter;
    private final Function<SaveContactRestRequest, Contact> saveContactRestRequestConverter;

    @Override
    public Division apply(SaveDivisionRestRequest saveDivisionRestRequest) {
        if (saveDivisionRestRequest != null) {
            return Division.builder()
                    .acronym(saveDivisionRestRequest.getAcronym())
                    .name(saveDivisionRestRequest.getName())
                    .description(saveDivisionRestRequest.getDescription())
                    .address(saveAddressRestRequestConverter.apply(saveDivisionRestRequest.getAddress()))
                    .contact(saveContactRestRequestConverter.apply(saveDivisionRestRequest.getContact()))
                    .build();
        }

        return null;
    }
}
