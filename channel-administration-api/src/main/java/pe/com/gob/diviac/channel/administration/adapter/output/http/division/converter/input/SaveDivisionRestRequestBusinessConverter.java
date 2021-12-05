package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.ContactRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveAddressRestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveDivisionRestRequestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Address;
import pe.com.gob.diviac.channel.administration.entity.division.Contact;
import pe.com.gob.diviac.channel.administration.entity.division.Division;

@Builder
@RequiredArgsConstructor
public class SaveDivisionRestRequestBusinessConverter implements Function<Division, SaveDivisionRestRequestBusiness> {

    private final Function<Address, SaveAddressRestBusiness> saveAddressRestBusinessConverter;
    private final Function<Contact, ContactRestBusiness> contactRestBusinessConverter;

    @Override
    public SaveDivisionRestRequestBusiness apply(Division division) {
        if (division != null) {
            SaveDivisionRestRequestBusiness saveDivisionRestRequestBusiness = new SaveDivisionRestRequestBusiness();

            saveDivisionRestRequestBusiness.setAcronym(division.getAcronym());
            saveDivisionRestRequestBusiness.setName(division.getName());
            saveDivisionRestRequestBusiness.setDescription(division.getDescription());
            saveDivisionRestRequestBusiness.setAddress(saveAddressRestBusinessConverter.apply(division.getAddress()));
            saveDivisionRestRequestBusiness.setContact(contactRestBusinessConverter.apply(division.getContact()));

            return saveDivisionRestRequestBusiness;
        }

        return null;
    }
}
