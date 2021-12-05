package pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo.converter;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.adapter.contract.parameterv1.DepartmentBusinessResponse;
import pe.com.gob.diviac.channel.parameter.entity.Department;

@Builder
public class DepartmentConverter
        implements Function<DepartmentBusinessResponse, Department> {

    @Override
    public Department apply(DepartmentBusinessResponse departmentBusinessResponse) {
        if (departmentBusinessResponse != null) {
            return Department.builder()
                    .id(departmentBusinessResponse.getId())
                    .name(departmentBusinessResponse.getName())
                    .build();
        }
        return null;
    }
}
