package pe.com.gob.diviac.business.parameter.domain.port.input;

import java.util.List;

import pe.com.gob.diviac.business.parameter.entity.Department;
import pe.com.gob.diviac.business.parameter.entity.District;
import pe.com.gob.diviac.business.parameter.entity.Province;

public interface UbigeoUseCase {

    List<Department> findAllDepartments();

    List<Province> findProvincesByIdDepartment(Integer departmentId);

    List<District> findDistrictsByIdProvince(Integer provinceId);
}
