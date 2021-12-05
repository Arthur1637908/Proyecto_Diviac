package pe.com.gob.diviac.business.division.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contact {

    private String email;
    private String phoneNumber;
    private String annexNumber;

}
