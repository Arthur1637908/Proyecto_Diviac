package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.list.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.common.response.IdentityDocumentRestResponse;

@Getter
@Setter
@Schema(name = "IdentityDocumentItemResponseBusiness")
public class IdentityDocumentItemRestResponse extends IdentityDocumentRestResponse {

    @Builder
    public IdentityDocumentItemRestResponse(Long id, ParameterRestResponse documentType,
                                            String documentNumber, Boolean state) {
        super(id, documentType, documentNumber, state);
    }
}
