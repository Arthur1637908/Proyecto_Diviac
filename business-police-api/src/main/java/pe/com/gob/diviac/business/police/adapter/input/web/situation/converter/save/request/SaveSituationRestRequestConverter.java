package pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.save.request;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.SneakyThrows;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.request.SaveSituationRestRequest;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.util.DateUtils;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.enums.DateFormatEnum;
import pe.com.gob.diviac.business.police.util.enums.SituationTypeEnum;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Builder
public class SaveSituationRestRequestConverter implements Function<SaveSituationRestRequest, Situation> {

    @Override
    @SneakyThrows
    public Situation apply(SaveSituationRestRequest saveSituationRestRequest) {
        if (Objects.isNull(saveSituationRestRequest)) {
            return null;
        }

        return Situation.builder()
                .police(this.getPolice(saveSituationRestRequest.getPoliceId()))
                .situationType(this.getSituationType(saveSituationRestRequest.getSituationTypeId()))
                .division(this.getDivision(saveSituationRestRequest.getSituationTypeId(),
                        saveSituationRestRequest.getDivisionId()))
                .startDate(DateUtils.parse(saveSituationRestRequest.getStartDate(), DateFormatEnum.DD_MM_YYYY))
                .endDate(DateUtils.parse(saveSituationRestRequest.getEndDate(), DateFormatEnum.DD_MM_YYYY))
                .documentName(this.getDocumentName(saveSituationRestRequest.getDocument()))
                .documentContent(this.getDocumentContent(saveSituationRestRequest.getDocument()))
                .build();
    }

    private Police getPolice(UUID policeId) {
        if (Objects.isNull(policeId)) {
            return null;
        }

        return Police.builder()
                .id(policeId)
                .build();
    }

    private Parameter getSituationType(Integer situationTypeId) {
        if (Objects.isNull(situationTypeId)) {
            return null;
        }

        return Parameter.builder()
                .id(situationTypeId)
                .build();
    }

    private Division getDivision(Integer situationTypeId, UUID divisionId) {
        if (Objects.isNull(divisionId)) {
            if (situationTypeId.equals(SituationTypeEnum.SUB_UNIT_SUPPORT.getId())) {
                throw new DiviacStatusException(HttpStatus.BAD_REQUEST,
                        ErrorConstants.ERROR_INVALID_REQUEST_CODE,
                        ErrorConstants.ERROR_INVALID_REQUEST_DESCRIPTION);
            }

            return null;
        }

        return Division.builder()
                .id(divisionId)
                .build();
    }

    private String getDocumentName(MultipartFile document) {
        if (Objects.isNull(document) || document.isEmpty()) {
            return null;
        }

        return document.getOriginalFilename();
    }

    private byte[] getDocumentContent(MultipartFile document) throws IOException {
        if (Objects.isNull(document) || document.isEmpty()) {
            return null;
        }
        return document.getBytes();
    }
}
