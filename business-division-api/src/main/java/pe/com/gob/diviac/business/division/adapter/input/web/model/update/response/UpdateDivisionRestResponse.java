package pe.com.gob.diviac.business.division.adapter.input.web.model.update.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.AddressRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.ContactRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.response.DivisionRestResponse;

@Getter
@Setter
@Schema(name = "UpdateDivisionResponseBusiness")
public class UpdateDivisionRestResponse extends DivisionRestResponse {

    @Builder
    public UpdateDivisionRestResponse(UUID id, String code, String acronym, String name, String description,
                                      AddressRestResponse address, ContactRestResponse contact) {
        super(id, code, acronym, name, description, address, contact);
    }
}
