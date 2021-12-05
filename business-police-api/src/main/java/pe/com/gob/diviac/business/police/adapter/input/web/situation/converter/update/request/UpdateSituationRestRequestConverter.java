package pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.update.request;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.update.request.UpdateSituationRestRequest;
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
@RequiredArgsConstructor
public class UpdateSituationRestRequestConverter
        implements Function<UpdateSituationRestRequestConverter.Wrapper, Situation> {

    @Override
    @SneakyThrows
    public Situation apply(Wrapper wrapper) {
        if (Objects.isNull(wrapper) || Objects.isNull(wrapper.getSituationId())
                || Objects.isNull(wrapper.getUpdateSituationRestRequest())) {
            return null;
        }

        return Situation.builder()
                .id(wrapper.getSituationId())
                .situationType(this.getSituationType(wrapper.getUpdateSituationRestRequest().getSituationTypeId()))
                .division(this.getDivision(wrapper.getUpdateSituationRestRequest().getSituationTypeId(),
                        wrapper.getUpdateSituationRestRequest().getDivisionId()))
                .startDate(DateUtils.parse(wrapper.getUpdateSituationRestRequest().getStartDate(),
                        DateFormatEnum.DD_MM_YYYY))
                .endDate(DateUtils.parse(wrapper.getUpdateSituationRestRequest().getEndDate(),
                        DateFormatEnum.DD_MM_YYYY))
                .documentName(this.getDocumentName(wrapper.getUpdateSituationRestRequest().getDocument()))
                .documentContent(this.getDocumentContent(wrapper.getUpdateSituationRestRequest().getDocument()))
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

    @Data
    @Builder
    public static class Wrapper {

        private Long situationId;
        private UpdateSituationRestRequest updateSituationRestRequest;
    }
}
