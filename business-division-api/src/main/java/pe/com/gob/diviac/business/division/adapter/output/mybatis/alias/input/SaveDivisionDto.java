package pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "SaveDivisionDto")
public class SaveDivisionDto {

    private String id;
    private String code;
    private String acronym;
    private String name;
    private String description;
    private Long addressId;
    private String email;
    private String phoneNumber;
    private String annexNumber;

}
