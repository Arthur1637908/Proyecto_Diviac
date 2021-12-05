package pe.com.gob.diviac.business.division.application.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.DependsOn;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.AddressAdapter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.DivisionAdapter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.SaveAddressDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.SaveDivisionDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.UpdateAddressDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input.UpdateDivisionDtoConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.output.ResponseDivisionConverter;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.mapper.AddressMapper;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.mapper.DivisionMapper;
import pe.com.gob.diviac.business.division.domain.port.output.AddressPort;
import pe.com.gob.diviac.business.division.domain.port.output.DivisionPort;
import pe.com.gob.diviac.business.division.domain.interactor.DivisionInteractor;
import pe.com.gob.diviac.business.division.domain.port.input.DivisionUseCase;

@Configuration
public class UseCaseConfiguration {

    @Bean
    @DependsOn({"saveDivisionDtoConverter", "updateDivisionDtoConverter", "responseDivisionConverter"})
    public DivisionPort personPort(DivisionMapper divisionMapper,
                                   SaveDivisionDtoConverter saveDivisionDtoConverter,
                                   UpdateDivisionDtoConverter updateDivisionDtoConverter,
                                   ResponseDivisionConverter responseDivisionConverter) {
        return DivisionAdapter.builder()
                .divisionMapper(divisionMapper)
                .saveDivisionDtoConverter(saveDivisionDtoConverter)
                .updateDivisionDtoConverter(updateDivisionDtoConverter)
                .responseDivisionConverter(responseDivisionConverter)
                .build();
    }

    @Bean
    @DependsOn({"saveAddressDtoConverter", "updateAddressDtoConverter"})
    public AddressPort addressPort(AddressMapper addressMapper,
                                   SaveAddressDtoConverter saveAddressDtoConverter,
                                   UpdateAddressDtoConverter updateAddressDtoConverter) {
        return AddressAdapter.builder()
                .addressMapper(addressMapper)
                .saveAddressDtoConverter(saveAddressDtoConverter)
                .updateAddressDtoConverter(updateAddressDtoConverter)
                .build();
    }

    @Bean
    public DivisionUseCase divisionUseCase(DivisionPort divisionPort,
                                           AddressPort addressPort) {
        return DivisionInteractor.builder()
                .divisionPort(divisionPort)
                .addressPort(addressPort)
                .build();
    }
}
