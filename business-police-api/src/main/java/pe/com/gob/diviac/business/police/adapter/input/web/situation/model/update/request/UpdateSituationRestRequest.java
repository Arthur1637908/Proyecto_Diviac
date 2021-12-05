package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.update.request;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.common.request.SituationRestRequest;
import pe.com.gob.diviac.business.police.util.FileUtils;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.constants.ValidationConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "UpdateSituationRequestBusiness")
public class UpdateSituationRestRequest extends SituationRestRequest {

    @Schema(description = "Situation file")
    private MultipartFile document;

    public UpdateSituationRestRequest(Integer situationTypeId, UUID divisionId, String startDate, String endDate,
                                      MultipartFile document) {
        super(situationTypeId, divisionId, startDate, endDate);
        this.document = document;
    }

    public void setDocument(MultipartFile document) {
        if (Objects.nonNull(document) && !document.isEmpty()) {
            if (!FileUtils.isValidFileExtension(document)) {
                throw new DiviacStatusException(HttpStatus.BAD_REQUEST,
                        ErrorConstants.ERROR_INVALID_REQUEST_CODE,
                        ErrorConstants.ERROR_INVALID_REQUEST_DESCRIPTION);
            }

            this.document = document;
        }
    }
}
