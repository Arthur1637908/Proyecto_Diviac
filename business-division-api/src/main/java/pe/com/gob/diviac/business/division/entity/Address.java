package pe.com.gob.diviac.business.division.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {

    private Long id;
    private String name;
    private String number;
    private Parameter type;
    private Ubigeo district;
    private Ubigeo province;
    private Ubigeo ubigeo;

}
