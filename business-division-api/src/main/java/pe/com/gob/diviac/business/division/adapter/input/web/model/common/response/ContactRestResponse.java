package pe.com.gob.diviac.business.division.adapter.input.web.model.common.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Schema(name = "ContactResponseBusiness")
public class ContactRestResponse {

    @Schema(description = "Email", example = "EMAIL@POLICIA.GOB.PE")
    private String email;

    @Schema(description = "Phone number", example = "5522113")
    private String phoneNumber;

    @Schema(description = "Annex number", example = "3212")
    private String annexNumber;

}
