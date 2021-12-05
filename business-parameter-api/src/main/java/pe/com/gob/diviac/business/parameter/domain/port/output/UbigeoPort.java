package pe.com.gob.diviac.business.parameter.domain.port.output;

import java.util.List;

import pe.com.gob.diviac.business.parameter.entity.Department;
import pe.com.gob.diviac.business.parameter.entity.District;
import pe.com.gob.diviac.business.parameter.entity.Province;

public interface UbigeoPort {

    List<Department> findAllDepartments();

    List<Province> findProvincesByIdDepartment(Integer departmentId);

    List<District> findDistrictsByIdProvince(Integer provinceId);
}
