package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.common.request.SituationRestRequest;
import pe.com.gob.diviac.business.police.util.FileUtils;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "SaveSituationRequestBusiness")
public class SaveSituationRestRequest extends SituationRestRequest {

    @NotNull
    @Schema(description = "Police identifier", example = "2e3f9448-494a-4319-bc14-9fbfe315eb6b", required = true)
    private UUID policeId;

    @NotNull
    @Schema(description = "Situation file", required = true)
    private MultipartFile document;

    public SaveSituationRestRequest(UUID policeId, Integer situationTypeId, UUID divisionId, String startDate,
                                    String endDate, MultipartFile document) {
        super(situationTypeId, divisionId, startDate, endDate);
        this.policeId = policeId;
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
