package pe.com.gob.diviac.channel.administration.application.usecase.division;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionListRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveDivisionRestRequestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateDivisionRestRequestBusiness;
import pe.com.gob.diviac.channel.administration.adapter.output.http.common.client.DivisionClient;
import pe.com.gob.diviac.channel.administration.adapter.output.http.division.DivisionAdapter;
import pe.com.gob.diviac.channel.administration.domain.interactor.DivisionInteractor;
import pe.com.gob.diviac.channel.administration.domain.port.input.DivisionUseCase;
import pe.com.gob.diviac.channel.administration.domain.port.output.DivisionPort;
import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public DivisionPort divisionPort(
            DivisionClient divisionClient,
            Function<Division, SaveDivisionRestRequestBusiness> saveDivisionRestRequestBusinessConverter,
            Function<Division, UpdateDivisionRestRequestBusiness> updateDivisionRestRequestBusinessConverter,
            Function<DivisionListRestResponseBusiness, DivisionListResponse> divisionListResponseConverter,
            Function<DivisionRestResponseBusiness, Division> divisionConverter) {
        return DivisionAdapter.builder()
                .divisionClient(divisionClient)
                .saveDivisionRestRequestBusinessConverter(saveDivisionRestRequestBusinessConverter)
                .updateDivisionRestRequestBusinessConverter(updateDivisionRestRequestBusinessConverter)
                .divisionListResponseConverter(divisionListResponseConverter)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public DivisionUseCase divisionUseCase(DivisionPort divisionPort) {
        return DivisionInteractor.builder()
                .divisionPort(divisionPort)
                .build();
    }
}
