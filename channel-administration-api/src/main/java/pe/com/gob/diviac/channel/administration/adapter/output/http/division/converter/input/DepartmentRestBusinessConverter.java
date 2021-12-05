package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.input;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.divisionv1.DepartmentRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Department;

@Builder
public class DepartmentRestBusinessConverter implements Function<Department, DepartmentRestBusiness> {

    @Override
    public DepartmentRestBusiness apply(Department department) {
        if (department != null) {
            DepartmentRestBusiness departmentRestBusiness = new DepartmentRestBusiness();

            departmentRestBusiness.setId(department.getId());
            departmentRestBusiness.setName(department.getName());

            return departmentRestBusiness;
        }
        return null;
    }
}
