package pe.com.gob.diviac.business.police.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Situation {

    private Long id;
    private Police police;
    private Parameter situationType;
    private Division division;
    private LocalDate startDate;
    private LocalDate endDate;
    private String documentName;
    private byte[] documentContent;
    private String documentPath;
    private Boolean state;
}
