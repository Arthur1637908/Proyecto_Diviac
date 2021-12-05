package pe.com.gob.diviac.business.division.adapter.input.web.converter.save.request;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.AddressRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.ContactRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.save.request.SaveDivisionRestRequest;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Contact;
import pe.com.gob.diviac.business.division.entity.Division;

@Builder
@RequiredArgsConstructor
public class SaveDivisionRestRequestConverter implements Function<SaveDivisionRestRequest, Division> {

    private final Function<AddressRestRequest, Address> addressRestRequestConverter;
    private final Function<ContactRestRequest, Contact> contactRestRequestConverter;

    @Override
    public Division apply(SaveDivisionRestRequest saveDivisionRestRequest) {
        if (Objects.isNull(saveDivisionRestRequest)) {
            return null;
        }

        return Division.builder()
                .acronym(saveDivisionRestRequest.getAcronym())
                .name(saveDivisionRestRequest.getName())
                .description(saveDivisionRestRequest.getDescription())
                .address(addressRestRequestConverter.apply(saveDivisionRestRequest.getAddress()))
                .contact(contactRestRequestConverter.apply(saveDivisionRestRequest.getContact()))
                .build();
    }
}
