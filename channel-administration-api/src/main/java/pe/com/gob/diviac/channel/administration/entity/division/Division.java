package pe.com.gob.diviac.channel.administration.entity.division;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
