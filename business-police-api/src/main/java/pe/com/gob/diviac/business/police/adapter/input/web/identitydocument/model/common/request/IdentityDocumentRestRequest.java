package pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.common.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.util.StringUtils;
import pe.com.gob.diviac.business.police.util.constants.ValidationConstants;

@Getter
@Setter
@AllArgsConstructor
public class IdentityDocumentRestRequest {

    @Min(1)
    @NotNull
    @Schema(description = "police identity document type id", example = "11")
    private Integer documentTypeId;

    @NotBlank
    @Pattern(regexp = ValidationConstants.DOCUMENT_NUMBER_REGEX)
    @Schema(description = "police identity document number", example = "78767908")
    private String documentNumber;

    public void setDocumentNumber(String documentNumber) {
        if (Objects.nonNull(documentNumber) && !documentNumber.trim().equals(StringUtils.EMPTY)) {
            this.documentNumber = documentNumber.trim().toUpperCase();
        }
    }
}
