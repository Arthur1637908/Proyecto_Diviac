package pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response;

import java.util.Objects;
import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PoliceRestResponse;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.util.StringUtils;

@Builder
public class PoliceRestResponseConverter implements Function<Police, PoliceRestResponse> {

    @Override
    public PoliceRestResponse apply(Police police) {
        if (Objects.isNull(police)) {
            return null;
        }

        return PoliceRestResponse.builder()
                .id(police.getId())
                .cip(police.getCip())
                .names(StringUtils.concatFields(police.getFirstName(), police.getSecondName()))
                .lastNames(StringUtils.concatFields(police.getLastName(), police.getSecondLastName()))
                .build();
    }
}
