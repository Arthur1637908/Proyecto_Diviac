package pe.com.gob.diviac.channel.administration.entity.division;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {

    private Long id;
    private Department department;
    private Province province;
    private District district;
    private AddressType type;
    private String name;
    private String number;
}
