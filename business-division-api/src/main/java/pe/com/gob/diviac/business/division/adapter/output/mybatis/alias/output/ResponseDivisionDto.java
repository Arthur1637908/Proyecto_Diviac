package pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "ResponseDivisionDto")
public class ResponseDivisionDto {

    private String id;
    private String code;
    private String acronym;
    private String name;
    private String description;
    private Long addressId;
    private String addressName;
    private String addressNumber;
    private Integer addressTypeId;
    private String addressTypeName;
    private Integer addressDistrictId;
    private String addressDistrictName;
    private Integer addressProvinceId;
    private String addressProvinceName;
    private Integer addressDepartmentId;
    private String addressDepartmentName;
    private String email;
    private String phoneNumber;
    private String annexNumber;

}
