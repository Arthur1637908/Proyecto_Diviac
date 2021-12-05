package pe.com.gob.diviac.business.police.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class IdentityDocument {

    private Long id;
    private Police police;
    private Parameter documentType;
    private String documentNumber;
    private Boolean state;
}
