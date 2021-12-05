package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import lombok.RequiredArgsConstructor;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceDivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;

@Builder
@RequiredArgsConstructor
public class PoliceConverter implements Function<PoliceEntity, Police> {

    private final Function<ParameterEntity, Parameter> parameterConverter;
    private final Function<DivisionEntity, Division> divisionConverter;

    @Override
    public Police apply(PoliceEntity policeEntity) {
        if (policeEntity  == null) {
            return null;
        }

        return Police.builder()
                .id(policeEntity.getId())
                .division(this.getDivision(policeEntity.getPoliceDivisionList()))
                .cip(policeEntity.getCip())
                .firstName(policeEntity.getFirstName())
                .secondName(policeEntity.getSecondName())
                .lastName(policeEntity.getLastName())
                .secondLastName(policeEntity.getSecondLastName())
                .position(parameterConverter.apply(policeEntity.getPosition()))
                .grade(parameterConverter.apply(policeEntity.getGrade()))
                .sex(parameterConverter.apply(policeEntity.getSex()))
                .dateOfBirth(policeEntity.getDateOfBirth())
                .pseudonym(policeEntity.getPseudonym())
                .civilStatus(parameterConverter.apply(policeEntity.getCivilStatus()))
                .state(policeEntity.getState())
                .build();
    }

    private Division getDivision(List<PoliceDivisionEntity> policeDivisionEntityList) {
        if (Objects.isNull(policeDivisionEntityList) || policeDivisionEntityList.isEmpty()) {
            return null;
        }

        return policeDivisionEntityList.stream()
                .filter(policeDivisionEntity -> Boolean.TRUE.equals(policeDivisionEntity.getState()))
                .findFirst()
                .map(policeDivisionEntity -> divisionConverter.apply(policeDivisionEntity.getDivision()))
                .orElse(null);
    }
}
