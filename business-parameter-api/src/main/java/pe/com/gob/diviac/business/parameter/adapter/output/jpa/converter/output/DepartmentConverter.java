package pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output;

import lombok.Builder;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DepartmentEntity;
import pe.com.gob.diviac.business.parameter.entity.Department;

import java.util.function.Function;

@Builder
public class DepartmentConverter implements Function<DepartmentEntity, Department> {

    @Override
    public Department apply(DepartmentEntity departmentEntity) {
        if (departmentEntity != null) {
            return Department.builder()
                    .id(departmentEntity.getIntIdDepartamento())
                    .name(departmentEntity.getVchNombreDepartamento())
                    .build();
        }

        return null;
    }
}
