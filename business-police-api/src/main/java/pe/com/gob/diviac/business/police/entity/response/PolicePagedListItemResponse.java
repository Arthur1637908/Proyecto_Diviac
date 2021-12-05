package pe.com.gob.diviac.business.police.entity.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;

@Getter
@Setter
@Builder
public class PolicePagedListItemResponse {

    private UUID id;
    private String cip;
    private String names;
    private String lastNames;
    private Division division;
    private Boolean state;
}
