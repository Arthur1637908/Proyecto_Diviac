package pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.update;

import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateAddressRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateContactRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateDivisionRestRequest;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;
import pe.com.gob.diviac.channel.administration.entity.division.Division;

@Builder
@RequiredArgsConstructor
public class UpdateDivisionRestRequestConverter
        implements Function<UpdateDivisionRestRequestConverter.Wrapper, Division> {

    private final Function<UpdateAddressRestRequest, Address> updateAddressRestRequestConverter;
    private final Function<UpdateContactRestRequest, Contact> updateContactRestRequestConverter;

    @Override
    public Division apply(UpdateDivisionRestRequestConverter.Wrapper wrapper) {
        if (wrapper != null) {
            if (wrapper.getUpdateDivisionRestRequest() != null) {
                return Division.builder()
                        .id(wrapper.getId())
                        .acronym(wrapper.getUpdateDivisionRestRequest().getAcronym())
                        .description(wrapper.getUpdateDivisionRestRequest().getDescription())
                        .address(updateAddressRestRequestConverter.apply(
                                wrapper.getUpdateDivisionRestRequest().getAddress()))
                        .contact(updateContactRestRequestConverter.apply(
                                wrapper.getUpdateDivisionRestRequest().getContact()))
                        .build();
            }
        }

        return null;
    }

    @Data
    @Builder
    public static class Wrapper {

        private UUID id;
        private UpdateDivisionRestRequest updateDivisionRestRequest;
    }
}
