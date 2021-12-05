package pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceDivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListItemResponse;
import pe.com.gob.diviac.business.police.util.StringUtils;

@Builder
@RequiredArgsConstructor
public class PolicePagedListItemResponseConverter
        implements Function<PoliceEntity, PolicePagedListItemResponse> {

    private final Function<IdentityDocumentEntity, IdentityDocument> identityDocumentConverter;
    private final Function<DivisionEntity, Division> divisionConverter;

    @Override
    public PolicePagedListItemResponse apply(PoliceEntity policeEntity) {
        if (Objects.isNull(policeEntity)) {
            return null;
        }

        return PolicePagedListItemResponse.builder()
                .id(policeEntity.getId())
                .cip(policeEntity.getCip())
                .names(this.getNames(policeEntity.getFirstName(), policeEntity.getSecondName()))
                .lastNames(this.getLastNames(policeEntity.getLastName(), policeEntity.getSecondLastName()))
                .division(this.getDivision(policeEntity.getPoliceDivisionList()))
                .state(policeEntity.getState())
                .build();
    }

    private String getNames(String firstName, String secondName) {
        return StringUtils.concatFields(firstName, secondName);
    }

    private String getLastNames(String lastName, String secondLastName) {
        return StringUtils.concatFields(lastName, secondLastName);
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
