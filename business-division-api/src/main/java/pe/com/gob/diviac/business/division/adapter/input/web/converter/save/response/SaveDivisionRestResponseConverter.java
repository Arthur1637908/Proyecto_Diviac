package pe.com.gob.diviac.business.division.adapter.input.web.converter.save.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.AddressRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ContactRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.save.response.SaveDivisionRestResponse;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Contact;
import pe.com.gob.diviac.business.division.entity.Division;

@Builder
@RequiredArgsConstructor
public class SaveDivisionRestResponseConverter implements Function<Division, SaveDivisionRestResponse> {

    private final Function<Address, AddressRestResponse> addressRestResponseConverter;
    private final Function<Contact, ContactRestResponse> contactRestResponseConverter;

    @Override
    public SaveDivisionRestResponse apply(Division division) {
        if (Objects.isNull(division)) {
            return null;
        }

        return SaveDivisionRestResponse.builder()
                .id(division.getId())
                .code(division.getCode())
                .acronym(division.getAcronym())
                .name(division.getName())
                .description(division.getDescription())
                .address(addressRestResponseConverter.apply(division.getAddress()))
                .contact(contactRestResponseConverter.apply(division.getContact()))
                .build();
    }
}
