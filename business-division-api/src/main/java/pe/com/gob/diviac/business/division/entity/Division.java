package pe.com.gob.diviac.business.division.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Division {

    private UUID id;
    private String code;
    private String acronym;
    private String name;
    private String description;
    private Address address;
    private Contact contact;

}
