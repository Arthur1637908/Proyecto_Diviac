package pe.com.gob.diviac.business.division.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveAddressDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateAddressDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.output.ResponseDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.SaveAddressDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.SaveDivisionDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.UpdateAddressDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.UpdateDivisionDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.output.ResponseDivisionConverter;
import pe.com.gob.diviac.business.division.entity.Address;
import pe.com.gob.diviac.business.division.entity.Division;

@Configuration
public class MyBatisConfiguration {

    @Bean
    public Function<Address, SaveAddressDto>  saveAddressDtoConverter() {
        return SaveAddressDtoConverter.builder()
                .build();
    }

    @Bean
    public Function<Division, SaveDivisionDto> saveDivisionDtoConverter() {
        return SaveDivisionDtoConverter.builder()
                .build();
    }

    @Bean
    public Function<Address, UpdateAddressDto> updateAddressDtoConverter() {
        return UpdateAddressDtoConverter.builder()
                .build();
    }

    @Bean
    public Function<Division, UpdateDivisionDto> updateDivisionDtoConverter() {
        return UpdateDivisionDtoConverter.builder()
                .build();
    }

    @Bean
    public Function<ResponseDivisionDto, Division> responseDivisionConverter() {
        return ResponseDivisionConverter.builder()
                .build();
    }

}
