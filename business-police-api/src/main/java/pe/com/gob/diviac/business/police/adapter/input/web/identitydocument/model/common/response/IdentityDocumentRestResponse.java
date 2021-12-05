package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.common.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;

@Getter
@Setter
@AllArgsConstructor
public class IdentityDocumentRestResponse {

    @Schema(description = "Identifier", example = "1")
    private Long id;

    @Schema(description = "Document type information")
    private ParameterRestResponse documentType;

    @Schema(description = "Document number", example = "76543211")
    private String documentNumber;

    @Schema(description = "State", example = "true")
    private Boolean state;
}
