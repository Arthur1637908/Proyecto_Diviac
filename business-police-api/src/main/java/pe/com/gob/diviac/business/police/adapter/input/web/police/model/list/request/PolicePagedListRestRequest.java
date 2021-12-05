package pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.request;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import pe.com.gob.diviac.business.police.util.constants.ValidationConstants;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PolicePagedListRequestBusiness")
public class PolicePagedListRestRequest {

    @Pattern(regexp = ValidationConstants.CIP_FILTER_REGEX)
    @Schema(description = "Police identification code",  example = "1234567")
    private String cip;

    @Pattern(regexp = ValidationConstants.POLICE_NAME_FILTER_REGEX)
    @Schema(description = "Police name", example = "MANOLO")
    private String name;

    @Min(1)
    @Schema(description = "Document type identifier", example = "1")
    private Integer documentTypeId;

    @Pattern(regexp = ValidationConstants.DOCUMENT_NUMBER_FILTER_REGEX)
    @Schema(description = "Document number", example = "76543211")
    private String documentNumber;

    @Min(1)
    @NotNull
    @Schema(description = "Current page", example = "1")
    private Integer currentPage;

    @Min(1)
    @NotNull
    @Schema(description = "Page size", example = "10")
    private Integer pageSize;

    public void setCip(String cip) {
        if (Objects.nonNull(cip) && !cip.trim().equals(StringUtils.EMPTY)) {
            this.cip = cip.trim();
        }
    }

    public void setName(String name) {
        if (Objects.nonNull(name) && !name.trim().equals(StringUtils.EMPTY)) {
            this.name = name.trim().toUpperCase();
        }
    }

    public void setDocumentNumber(String documentNumber) {
        if (Objects.nonNull(documentNumber) && !documentNumber.trim().equals(StringUtils.EMPTY)) {
            this.documentNumber = documentNumber.trim().toUpperCase();
        }
    }
}
