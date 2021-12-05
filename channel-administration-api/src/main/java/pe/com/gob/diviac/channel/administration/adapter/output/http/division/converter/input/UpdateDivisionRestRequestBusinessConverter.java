package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.adapter.contract.divisionv1.ContactRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateAddressRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateDivisionRestRequestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;
import pe.com.gob.diviac.channel.administration.entity.division.Division;

@Builder
@RequiredArgsConstructor
public class UpdateDivisionRestRequestBusinessConverter
        implements Function<Division, UpdateDivisionRestRequestBusiness> {

    private final Function<Address, UpdateAddressRestBusiness> updateAddressRestBusinessConverter;
    private final Function<Contact, ContactRestBusiness> contactRestBusinessConverter;

    @Override
    public UpdateDivisionRestRequestBusiness apply(Division division) {
        if (division != null) {
            UpdateDivisionRestRequestBusiness updateDivisionRestRequestBusiness = new UpdateDivisionRestRequestBusiness();

            updateDivisionRestRequestBusiness.setAcronym(division.getAcronym());
            updateDivisionRestRequestBusiness.setDescription(division.getDescription());
            updateDivisionRestRequestBusiness.setAddress(updateAddressRestBusinessConverter.apply(division.getAddress()));
            updateDivisionRestRequestBusiness.setContact(contactRestBusinessConverter.apply(division.getContact()));

            return updateDivisionRestRequestBusiness;
        }

        return null;
    }
}
