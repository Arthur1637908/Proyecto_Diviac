package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.update.request;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.Data;

import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.update.request.UpdateGeneralInformationRestRequest;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.util.DateUtils;
import pe.com.gob.diviac.business.police.util.enums.DateFormatEnum;

@Builder
public class UpdateGeneralInformationRestRequestConverter
        implements Function<UpdateGeneralInformationRestRequestConverter.Wrapper, Police> {

    @Override
    public Police apply(UpdateGeneralInformationRestRequestConverter.Wrapper wrapper) {
        if (Objects.isNull(wrapper) || Objects.isNull(wrapper.getPoliceId()) ||
                Objects.isNull(wrapper.getUpdateGeneralInformationRestRequest())) {
            return null;
        }

        return Police.builder()
                .id(wrapper.getPoliceId())
                .division(this.buildDivision(wrapper.getUpdateGeneralInformationRestRequest().getDivisionId()))
                .firstName(wrapper.getUpdateGeneralInformationRestRequest().getFirstName())
                .secondName(wrapper.getUpdateGeneralInformationRestRequest().getSecondName())
                .lastName(wrapper.getUpdateGeneralInformationRestRequest().getLastName())
                .secondLastName(wrapper.getUpdateGeneralInformationRestRequest().getSecondLastName())
                .position(this.buildParameter(wrapper.getUpdateGeneralInformationRestRequest().getPositionId()))
                .grade(this.buildParameter(wrapper.getUpdateGeneralInformationRestRequest().getGradeId()))
                .sex(this.buildParameter(wrapper.getUpdateGeneralInformationRestRequest().getSexId()))
                .dateOfBirth(DateUtils.parse(wrapper.getUpdateGeneralInformationRestRequest().getDateOfBirth(),
                        DateFormatEnum.DD_MM_YYYY))
                .pseudonym(wrapper.getUpdateGeneralInformationRestRequest().getPseudonym())
                .civilStatus(this.buildParameter(wrapper.getUpdateGeneralInformationRestRequest().getCivilStatusId()))
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

    @Data
    @Builder
    public static class Wrapper {

        private UUID policeId;
        private UpdateGeneralInformationRestRequest updateGeneralInformationRestRequest;
    }
}
