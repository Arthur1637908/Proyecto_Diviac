package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.save.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.common.request.IdentityDocumentRestRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Schema(name = "SaveIdentityDocumentRequestBusiness")
public class SaveIdentityDocumentRestRequest extends IdentityDocumentRestRequest {

    @NotNull
    @Schema(description = "police id", example = "f0464d4e-2d23-4d28-bb70-dcae39961918")
    private UUID policeId;

    public SaveIdentityDocumentRestRequest(UUID policeId, Integer documentTypeId, String documentNumber) {
        super(documentTypeId, documentNumber);
        this.policeId = policeId;
    }
}
