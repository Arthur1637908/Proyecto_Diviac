package pe.com.gob.diviac.channel.parameter.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.adapter.contract.parameterv1.DepartmentBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.DistrictBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.ParameterBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.ProvinceBusinessResponse;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.common.client.UbigeoClient;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.parameter.ParameterAdapter;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.common.client.ParameterClient;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo.UbigeoAdapter;
import pe.com.gob.diviac.channel.parameter.domain.interactor.ParameterInteractor;
import pe.com.gob.diviac.channel.parameter.domain.interactor.UbigeoInteractor;
import pe.com.gob.diviac.channel.parameter.domain.port.input.ParameterUseCase;
import pe.com.gob.diviac.channel.parameter.domain.port.input.UbigeoUseCase;
import pe.com.gob.diviac.channel.parameter.domain.port.output.ParameterPort;
import pe.com.gob.diviac.channel.parameter.domain.port.output.UbigeoPort;
import pe.com.gob.diviac.channel.parameter.entity.Department;
import pe.com.gob.diviac.channel.parameter.entity.District;
import pe.com.gob.diviac.channel.parameter.entity.Parameter;
import pe.com.gob.diviac.channel.parameter.entity.Province;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public ParameterPort parameterPort(ParameterClient parameterClient,
                                       Function<ParameterBusinessResponse, Parameter> parameterConverter) {
        return ParameterAdapter.builder()
                .parameterClient(parameterClient)
                .parameterConverter(parameterConverter)
                .build();
    }

    @Bean
    public UbigeoPort ubigeoPort(UbigeoClient ubigeoClient,
                                 Function<DepartmentBusinessResponse, Department> departmentConverter,
                                 Function<ProvinceBusinessResponse, Province> provinceConverter,
                                 Function<DistrictBusinessResponse, District> districtConverter) {
        return UbigeoAdapter.builder()
                .ubigeoClient(ubigeoClient)
                .departmentConverter(departmentConverter)
                .provinceConverter(provinceConverter)
                .districtConverter(districtConverter)
                .build();
    }

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
}
