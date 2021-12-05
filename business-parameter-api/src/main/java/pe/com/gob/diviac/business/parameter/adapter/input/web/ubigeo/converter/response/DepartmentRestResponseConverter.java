package pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.converter.response;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.model.response.DepartmentRestResponse;
import pe.com.gob.diviac.business.parameter.entity.Department;

@Builder
public class DepartmentRestResponseConverter implements Function<Department, DepartmentRestResponse> {

    @Override
    public DepartmentRestResponse apply(Department department) {
        if (department != null) {
            return DepartmentRestResponse.builder()
                    .id(department.getId())
                    .name(department.getName())
                    .build();
        }

        return null;
    }

}
