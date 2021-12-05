package pe.com.gob.diviac.business.division.adapter.input.web.model.update.request;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.AddressRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.ContactRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.DivisionRestRequest;

@Getter
@Setter
@Schema(name = "UpdateDivisionRequestBusiness")
public class UpdateDivisionRestRequest extends DivisionRestRequest {

    public UpdateDivisionRestRequest(String acronym, String name, String description,
                                     AddressRestRequest address, ContactRestRequest contact) {
        super(acronym, name, description, address, contact);
    }
}
