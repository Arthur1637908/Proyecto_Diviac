package pe.com.gob.diviac.channel.parameter.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.adapter.contract.parameterv1.DepartmentBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.DistrictBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.ParameterBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.ProvinceBusinessResponse;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.parameter.converter.response.ParameterRestResponseConverter;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.parameter.model.response.ParameterRestResponse;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.converter.response.DepartmentRestResponseConverter;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.converter.response.DistrictRestResponseConverter;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.converter.response.ProvinceRestResponseConverter;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response.DepartmentRestResponse;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response.DistrictRestResponse;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response.ProvinceRestResponse;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.parameter.converter.ParameterConverter;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo.converter.DepartmentConverter;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo.converter.DistrictConverter;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo.converter.ProvinceConverter;
import pe.com.gob.diviac.channel.parameter.entity.Department;
import pe.com.gob.diviac.channel.parameter.entity.District;
import pe.com.gob.diviac.channel.parameter.entity.Parameter;
import pe.com.gob.diviac.channel.parameter.entity.Province;

@Configuration
public class ConverterConfiguration {

    /**
     * Inject Domain Converter
     */

    @Bean
    public Function<ParameterBusinessResponse, Parameter> parameterConverter() {
        return ParameterConverter.builder().build();
    }

    @Bean
    public Function<DepartmentBusinessResponse, Department> departmentConverter() {
        return DepartmentConverter.builder()
                .build();
    }

    @Bean
    public Function<DistrictBusinessResponse, District> districtConverter() {
        return DistrictConverter.builder()
                .build();
    }

    @Bean
    public Function<ProvinceBusinessResponse, Province> provinceConverter() {
        return ProvinceConverter.builder()
                .build();
    }

    /**
     * Inject Request and Response Converter
     */

    @Bean
    public Function<Parameter, ParameterRestResponse> parameterRestResponseConverter() {
        return ParameterRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Department, DepartmentRestResponse> departmentRestResponseConverter() {
        return DepartmentRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<District, DistrictRestResponse> districtRestResponseConverter() {
        return DistrictRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Province, ProvinceRestResponse> provinceRestResponseConverter() {
        return ProvinceRestResponseConverter.builder()
                .build();
    }
}
