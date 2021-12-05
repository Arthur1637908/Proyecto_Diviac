package pe.com.gob.diviac.channel.administration.adapter.output.http.division.converter.output;

import lombok.Builder;

import java.util.function.Function;

import pe.com.gob.diviac.adapter.contract.divisionv1.DepartmentRestBusiness;
import pe.com.gob.diviac.channel.administration.entity.division.Department;

@Builder
public class DepartmentConverter implements Function<DepartmentRestBusiness, Department> {

    @Override
    public Department apply(DepartmentRestBusiness departmentRestBusiness) {
        if (departmentRestBusiness != null) {
            return Department.builder()
                    .id(departmentRestBusiness.getId())
                    .name(departmentRestBusiness.getName())
                    .build();
        }

        return null;
    }
}
