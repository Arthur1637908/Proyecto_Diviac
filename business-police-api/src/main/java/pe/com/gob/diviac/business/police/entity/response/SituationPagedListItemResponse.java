package pe.com.gob.diviac.business.police.entity.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;

@Getter
@Setter
@Builder
public class SituationPagedListItemResponse {

    private Long id;
    private Parameter situationType;
    private Division division;
    private LocalDate startDate;
    private LocalDate endDate;
    private String documentName;
    private Boolean state;
}
