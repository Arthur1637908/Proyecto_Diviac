package pe.com.gob.diviac.business.police.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;

import pe.com.gob.diviac.business.police.adapter.output.postgres.DivisionApiAdapter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.FileApiAdapter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.ParameterApiAdapter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.PoliceDivisionApiAdapter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.IdentityDocumentApiAdapter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.PoliceApiAdapter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.SituationApiAdapter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.IdentityDocumentEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.PoliceDivisionEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.IdentityDocumentConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceDivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.SituationEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.DivisionJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.IdentityDocumentJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.ParameterJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.PoliceDivisionJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.PoliceJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.SituationJpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.specification.PoliceEntitySpecification;
import pe.com.gob.diviac.business.police.domain.interactor.GeneralInformationInteractor;
import pe.com.gob.diviac.business.police.domain.interactor.IdentityDocumentInteractor;
import pe.com.gob.diviac.business.police.domain.interactor.PoliceInteractor;
import pe.com.gob.diviac.business.police.domain.interactor.SituationInteractor;
import pe.com.gob.diviac.business.police.domain.port.input.GeneralInformationUseCase;
import pe.com.gob.diviac.business.police.domain.port.input.IdentityDocumentUseCase;
import pe.com.gob.diviac.business.police.domain.port.input.PoliceUseCase;
import pe.com.gob.diviac.business.police.domain.port.input.SituationUseCase;
import pe.com.gob.diviac.business.police.domain.port.output.DivisionPort;
import pe.com.gob.diviac.business.police.domain.port.output.FilePort;
import pe.com.gob.diviac.business.police.domain.port.output.ParameterPort;
import pe.com.gob.diviac.business.police.domain.port.output.PoliceDivisionPort;
import pe.com.gob.diviac.business.police.domain.port.output.IdentityDocumentPort;
import pe.com.gob.diviac.business.police.domain.port.output.PolicePort;
import pe.com.gob.diviac.business.police.domain.port.output.SituationPort;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

@Configuration
public class UseCaseConfiguration {

    /**
     * Output Port Beans
     */

    @Bean
    public DivisionPort divisionPort(DivisionJpaRepository divisionJpaRepository,
                                     Function<DivisionEntity, Division> divisionConverter) {
        return DivisionApiAdapter.builder()
                .divisionJpaRepository(divisionJpaRepository)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public FilePort filePort() {
        return FileApiAdapter.builder()
                .build();
    }

    @Bean
    @DependsOn({"identityDocumentConverter", "identityDocumentEntityConverter"})
    public IdentityDocumentPort identityDocumentPort(IdentityDocumentJpaRepository identityDocumentJpaRepository,
                                                     ParameterJpaRepository parameterJpaRepository,
                                                     Function<Parameter, ParameterEntity> parameterEntityConverter,
                                                     IdentityDocumentConverter identityDocumentConverter,
                                                     IdentityDocumentEntityConverter identityDocumentEntityConverter) {
        return IdentityDocumentApiAdapter.builder()
                .identityDocumentJpaRepository(identityDocumentJpaRepository)
                .parameterJpaRepository(parameterJpaRepository)
                .parameterEntityConverter(parameterEntityConverter)
                .identityDocumentConverter(identityDocumentConverter)
                .identityDocumentEntityConverter(identityDocumentEntityConverter)
                .build();
    }

    @Bean
    public ParameterPort parameterPort(ParameterJpaRepository parameterJpaRepository,
                                       Function<ParameterEntity, Parameter> parameterConverter) {
        return ParameterApiAdapter.builder()
                .parameterJpaRepository(parameterJpaRepository)
                .parameterConverter(parameterConverter)
                .build();
    }

    @Bean
    public PoliceDivisionPort policeDivisionPort(
            PoliceJpaRepository policeJpaRepository,
            DivisionJpaRepository divisionJpaRepository,
            PoliceDivisionJpaRepository policeDivisionJpaRepository,
            Function<PoliceDivisionEntityConverter.Wrapper, PoliceDivisionEntity> policeDivisionEntityConverter,
            Function<DivisionEntity, Division> divisionConverter) {
        return PoliceDivisionApiAdapter.builder()
                .policeJpaRepository(policeJpaRepository)
                .divisionJpaRepository(divisionJpaRepository)
                .policeDivisionJpaRepository(policeDivisionJpaRepository)
                .policeDivisionEntityConverter(policeDivisionEntityConverter)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public PolicePort policePort(
            PoliceJpaRepository policeJpaRepository,
            ParameterJpaRepository parameterJpaRepository,
            PoliceEntitySpecification policeEntitySpecification,
            Function<Police, PoliceEntity> policeEntityConverter,
            Function<Parameter, ParameterEntity> parameterEntityConverter,
            Function<Page<PoliceEntity>, PolicePagedListResponse> policePagedListResponseConverter,
            Function<PoliceEntity, Police> policeConverter) {
        return PoliceApiAdapter.builder()
                .policeJpaRepository(policeJpaRepository)
                .parameterJpaRepository(parameterJpaRepository)
                .policeEntitySpecification(policeEntitySpecification)
                .policeEntityConverter(policeEntityConverter)
                .parameterEntityConverter(parameterEntityConverter)
                .policePagedListResponseConverter(policePagedListResponseConverter)
                .policeConverter(policeConverter)
                .build();
    }

    @Bean
    public SituationPort situationPort(
            SituationJpaRepository situationJpaRepository,
            ParameterJpaRepository parameterJpaRepository,
            Function<Page<SituationEntity>, SituationPagedListResponse> situationPagedListResponseConverter,
            Function<Parameter, ParameterEntity> parameterEntityConverter,
            Function<Police, PoliceEntity> policeEntityConverter,
            Function<Division, DivisionEntity> divisionEntityConverter,
            Function<Situation, SituationEntity> situationEntityConverter,
            Function<SituationEntity, Situation> situationConverter) {
        return SituationApiAdapter.builder()
                .situationJpaRepository(situationJpaRepository)
                .parameterJpaRepository(parameterJpaRepository)
                .situationPagedListResponseConverter(situationPagedListResponseConverter)
                .parameterEntityConverter(parameterEntityConverter)
                .policeEntityConverter(policeEntityConverter)
                .divisionEntityConverter(divisionEntityConverter)
                .situationEntityConverter(situationEntityConverter)
                .situationConverter(situationConverter)
                .build();
    }

    /**
     * UseCase Beans
     */

    @Bean
    public GeneralInformationUseCase generalInformationUseCase(PolicePort policePort,
                                                               PoliceDivisionPort policeDivisionPort) {
        return GeneralInformationInteractor.builder()
                .policePort(policePort)
                .policeDivisionPort(policeDivisionPort)
                .build();
    }

    @Bean
    public PoliceUseCase policeUseCase(PolicePort policePort, SituationPort situationPort,
                                       IdentityDocumentPort identityDocumentPort) {
        return PoliceInteractor.builder()
                .policePort(policePort)
                .situationPort(situationPort)
                .identityDocumentPort(identityDocumentPort)
                .build();
    }

    @Bean
    public IdentityDocumentUseCase identityDocumentUseCase(ParameterPort parameterPort,
                                                           PolicePort policePort,
                                                           IdentityDocumentPort identityDocumentPort) {
        return IdentityDocumentInteractor.builder()
                .parameterPort(parameterPort)
                .policePort(policePort)
                .identityDocumentPort(identityDocumentPort)
                .build();
    }

    @Bean
    public SituationUseCase situationUseCase(PolicePort policePort,
                                             DivisionPort divisionPort,
                                             ParameterPort parameterPort,
                                             SituationPort situationPort,
                                             FilePort filePort) {
        return SituationInteractor.builder()
                .policePort(policePort)
                .divisionPort(divisionPort)
                .parameterPort(parameterPort)
                .situationPort(situationPort)
                .filePort(filePort)
                .build();
    }
}
