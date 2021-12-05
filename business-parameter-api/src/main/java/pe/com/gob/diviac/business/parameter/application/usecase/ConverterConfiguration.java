package pe.com.gob.diviac.business.parameter.application.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.converter.response.DepartmentRestResponseConverter;
import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.converter.response.DistrictRestResponseConverter;
import pe.com.gob.diviac.business.parameter.adapter.input.web.parameter.converter.response.ParameterRestResponseConverter;
import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.converter.response.ProvinceRestResponseConverter;
import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.model.response.DepartmentRestResponse;
import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.model.response.DistrictRestResponse;
import pe.com.gob.diviac.business.parameter.adapter.input.web.parameter.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.parameter.adapter.input.web.ubigeo.model.response.ProvinceRestResponse;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output.DepartmentConverter;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output.DistrictConverter;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output.ParameterConverter;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.converter.output.ProvinceConverter;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DepartmentEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DistrictEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ParameterEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ProvinceEntity;
import pe.com.gob.diviac.business.parameter.entity.Department;
import pe.com.gob.diviac.business.parameter.entity.District;
import pe.com.gob.diviac.business.parameter.entity.Parameter;
import pe.com.gob.diviac.business.parameter.entity.Province;

import java.util.function.Function;

@Configuration
public class ConverterConfiguration {

    /**
     * Inject Entities Converter
     */

    @Bean
    public Function<DepartmentEntity, Department> departmentConverter() {
        return DepartmentConverter.builder()
                .build();
    }

    @Bean
    public Function<DistrictEntity, District> districtConverter() {
        return DistrictConverter.builder()
                .build();
    }

    @Bean
    public Function<ParameterEntity, Parameter> parameterConverter() {
        return ParameterConverter.builder()
                .build();
    }

    @Bean
    public Function<ProvinceEntity, Province> provinceConverter() {
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
