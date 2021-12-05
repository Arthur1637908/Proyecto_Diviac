package pe.com.gob.diviac.channel.parameter.domain.port.input;

import java.util.List;

import pe.com.gob.diviac.channel.parameter.entity.Department;
import pe.com.gob.diviac.channel.parameter.entity.District;
import pe.com.gob.diviac.channel.parameter.entity.Province;

public interface UbigeoUseCase {

    List<Department> findAllDepartments();

    List<Province> findProvincesByIdDepartment(Integer departmentId);

    List<District> findDistrictsByIdProvince(Integer provinceId);
}
