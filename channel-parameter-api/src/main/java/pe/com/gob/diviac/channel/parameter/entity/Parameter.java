package pe.com.gob.diviac.channel.parameter.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Parameter {

    private Integer id;

    private String name;

    private Boolean state;

}
