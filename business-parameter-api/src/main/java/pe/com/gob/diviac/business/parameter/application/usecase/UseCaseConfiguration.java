package pe.com.gob.diviac.business.parameter.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.business.parameter.adapter.output.jpa.ParameterAdapter;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.UbigeoAdapter;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DepartmentEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DistrictEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ParameterEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ProvinceEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.DepartmentRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.DistrictRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.ParameterRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.ProvinceRepository;
import pe.com.gob.diviac.business.parameter.domain.interactor.ParameterInteractor;
import pe.com.gob.diviac.business.parameter.domain.interactor.UbigeoInteractor;
import pe.com.gob.diviac.business.parameter.domain.port.input.ParameterUseCase;
import pe.com.gob.diviac.business.parameter.domain.port.input.UbigeoUseCase;
import pe.com.gob.diviac.business.parameter.domain.port.output.ParameterPort;
import pe.com.gob.diviac.business.parameter.domain.port.output.UbigeoPort;
import pe.com.gob.diviac.business.parameter.entity.Department;
import pe.com.gob.diviac.business.parameter.entity.District;
import pe.com.gob.diviac.business.parameter.entity.Parameter;
import pe.com.gob.diviac.business.parameter.entity.Province;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public ParameterUseCase parameterUseCase(ParameterPort parameterPort) {
        return ParameterInteractor.builder()
                .parameterPort(parameterPort)
                .build();
    }

    @Bean
    public UbigeoUseCase ubigeoUseCase(UbigeoPort ubigeoPort) {
        return UbigeoInteractor.builder()
                .ubigeoPort(ubigeoPort)
                .build();
    }

    @Bean
    public ParameterPort parameterPort(ParameterRepository parameterRepository,
                                       Function<ParameterEntity, Parameter> parameterEntityConverter) {
        return ParameterAdapter.builder()
                .parameterRepository(parameterRepository)
                .parameterConverter(parameterEntityConverter)
                .build();
    }

    @Bean
    public UbigeoPort ubigeoPort(DepartmentRepository departmentRepository,
                                 ProvinceRepository provinceRepository,
                                 DistrictRepository districtRepository,
                                 Function<DepartmentEntity, Department> departmentEntityConverter,
                                 Function<ProvinceEntity, Province> provinceEntityConverter,
                                 Function<DistrictEntity, District> districtEntityConverter) {
        return UbigeoAdapter.builder()
                .departmentRepository(departmentRepository)
                .provinceRepository(provinceRepository)
                .districtRepository(districtRepository)
                .departmentConverter(departmentEntityConverter)
                .provinceConverter(provinceEntityConverter)
                .districtConverter(districtEntityConverter)
                .build();
    }

}
