package pe.com.gob.diviac.channel.parameter.domain.port.output;

import pe.com.gob.diviac.channel.parameter.entity.Department;
import pe.com.gob.diviac.channel.parameter.entity.District;
import pe.com.gob.diviac.channel.parameter.entity.Province;

import java.util.List;

public interface UbigeoPort {

    List<Department> findAllDepartments();

    List<Province> findProvincesByIdDepartment(Integer departmentId);

    List<District> findDistrictsByIdProvince(Integer provinceId);
}
