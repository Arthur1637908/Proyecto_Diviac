package pe.com.gob.diviac.business.division.adapter.input.web.converter.update.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.AddressRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ContactRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.update.response.UpdateDivisionRestResponse;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Contact;
import pe.com.gob.diviac.business.division.entity.Division;

@Builder
@RequiredArgsConstructor
public class UpdateDivisionRestResponseConverter implements Function<Division, UpdateDivisionRestResponse> {

    private final Function<Address, AddressRestResponse> updateAddressRestResponseConverter;
    private final Function<Contact, ContactRestResponse> updateContactRestResponseConverter;

    @Override
    public UpdateDivisionRestResponse apply(Division division) {
        if (Objects.isNull(division)) {
            return null;
        }

        return UpdateDivisionRestResponse.builder()
                .id(division.getId())
                .code(division.getCode())
                .acronym(division.getAcronym())
                .name(division.getName())
                .description(division.getDescription())
                .address(updateAddressRestResponseConverter.apply(division.getAddress()))
                .contact(updateContactRestResponseConverter.apply(division.getContact()))
                .build();
    }

}
