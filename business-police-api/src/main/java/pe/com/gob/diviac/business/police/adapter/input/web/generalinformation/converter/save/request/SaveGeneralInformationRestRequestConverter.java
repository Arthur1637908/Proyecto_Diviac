package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.save.request;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.save.request.SaveGeneralInformationRestRequest;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.util.DateUtils;
import pe.com.gob.diviac.business.police.util.enums.DateFormatEnum;

@Builder
public class SaveGeneralInformationRestRequestConverter
        implements Function<SaveGeneralInformationRestRequest, Police> {

    @Override
    public Police apply(SaveGeneralInformationRestRequest saveGeneralInformationRestRequest) {
        if (Objects.isNull(saveGeneralInformationRestRequest)) {
            return null;
        }

        return Police.builder()
                .cip(saveGeneralInformationRestRequest.getCip())
                .division(this.buildDivision(saveGeneralInformationRestRequest.getDivisionId()))
                .firstName(saveGeneralInformationRestRequest.getFirstName())
                .secondName(saveGeneralInformationRestRequest.getSecondName())
                .lastName(saveGeneralInformationRestRequest.getLastName())
                .secondLastName(saveGeneralInformationRestRequest.getSecondLastName())
                .position(this.buildParameter(saveGeneralInformationRestRequest.getPositionId()))
                .grade(this.buildParameter(saveGeneralInformationRestRequest.getGradeId()))
                .sex(this.buildParameter(saveGeneralInformationRestRequest.getSexId()))
                .dateOfBirth(DateUtils.parse(saveGeneralInformationRestRequest.getDateOfBirth(), DateFormatEnum.DD_MM_YYYY))
                .pseudonym(saveGeneralInformationRestRequest.getPseudonym())
                .civilStatus(this.buildParameter(saveGeneralInformationRestRequest.getCivilStatusId()))
                .build();
    }

    private Division buildDivision(UUID divisionId) {
        return Division.builder()
                .id(divisionId)
                .build();
    }

    private Parameter buildParameter(Integer parameterId) {
        return Parameter.builder()
                .id(parameterId)
                .build();
    }
}
