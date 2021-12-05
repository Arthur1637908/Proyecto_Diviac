package pe.com.gob.diviac.business.police.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Division {

    private UUID id;
    private String name;
}
