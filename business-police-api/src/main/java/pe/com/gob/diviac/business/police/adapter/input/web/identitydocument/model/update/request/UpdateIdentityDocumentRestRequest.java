package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.update.request;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.common.request.IdentityDocumentRestRequest;

@Getter
@Setter
@Schema(name = "UpdateIdentityDocumentRequestBusiness")
public class UpdateIdentityDocumentRestRequest extends IdentityDocumentRestRequest {

    public UpdateIdentityDocumentRestRequest(Integer documentTypeId, String documentNumber) {
        super(documentTypeId, documentNumber);
    }

}
