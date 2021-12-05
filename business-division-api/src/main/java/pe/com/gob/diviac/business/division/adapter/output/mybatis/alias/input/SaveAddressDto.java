package pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "SaveAddressDto")
public class SaveAddressDto {

    private Long id;
    private String name;
    private String number;
    private Integer directionTypeId;
    private Integer districtId;

}
