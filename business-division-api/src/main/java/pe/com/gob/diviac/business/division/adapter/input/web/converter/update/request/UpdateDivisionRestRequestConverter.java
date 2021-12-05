package pe.com.gob.diviac.business.division.adapter.input.web.converter.update.request;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.AddressRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.ContactRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.update.request.UpdateDivisionRestRequest;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Contact;
import pe.com.gob.diviac.business.division.entity.Division;

@Builder
@RequiredArgsConstructor
public class UpdateDivisionRestRequestConverter
        implements Function<UpdateDivisionRestRequestConverter.Wrapper, Division> {

    private final Function<AddressRestRequest, Address> addressRestRequestConverter;
    private final Function<ContactRestRequest, Contact> contactRestRequestConverter;

    @Override
    public Division apply(Wrapper wrapper) {
        if (Objects.isNull(wrapper) || Objects.isNull(wrapper.getDivisionId())
                || Objects.isNull(wrapper.getUpdateDivisionRestRequest())) {
            return null;
        }

        return Division.builder()
                .id(wrapper.getDivisionId())
                .acronym(wrapper.getUpdateDivisionRestRequest().getAcronym())
                .name(wrapper.getUpdateDivisionRestRequest().getName())
                .description(wrapper.getUpdateDivisionRestRequest().getDescription())
                .address(addressRestRequestConverter.apply(wrapper.getUpdateDivisionRestRequest().getAddress()))
                .contact(contactRestRequestConverter.apply(wrapper.getUpdateDivisionRestRequest().getContact()))
                .build();
    }

    @Data
    @Builder
    public static class Wrapper {

        private UUID divisionId;
        private UpdateDivisionRestRequest updateDivisionRestRequest;

    }
}
