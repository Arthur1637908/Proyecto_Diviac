package pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "UpdateDivisionDto")
public class UpdateDivisionDto {

    private String id;
    private String acronym;
    private String description;
    private String email;
    private String phoneNumber;
    private String annexNumber;

}
