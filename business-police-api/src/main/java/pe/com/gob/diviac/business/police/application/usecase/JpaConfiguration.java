package pe.com.gob.diviac.business.police.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.DivisionEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.IdentityDocumentEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.ParameterEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.PoliceDivisionEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.PoliceEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.input.SituationEntityConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.DivisionConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.IdentityDocumentConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.PageResponseConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.ParameterConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.PoliceConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.PolicePagedListItemResponseConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.PolicePagedListResponseConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.SituationConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.SituationPagedListItemResponseConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.converter.output.SituationPagedListResponseConverter;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceDivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.SituationEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.specification.PoliceEntitySpecification;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.response.PageResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

@Configuration
public class JpaConfiguration {

    /**
     * Input Jpa Converter Beans
     */

    @Bean
    public Function<Division, DivisionEntity> divisionEntityConverter() {
        return DivisionEntityConverter.builder()
                .build();
    }

    @Bean
    public Function<IdentityDocument, IdentityDocumentEntity> identityDocumentEntityConverter(
            Function<Parameter, ParameterEntity> parameterEntityConverter,
            Function<Police, PoliceEntity> policeEntityConverter){
        return IdentityDocumentEntityConverter.builder()
                .parameterEntityConverter(parameterEntityConverter)
                .policeEntityConverter(policeEntityConverter)
                .build();
    }

    @Bean
    public Function<Parameter, ParameterEntity> parameterEntityConverter() {
        return ParameterEntityConverter.builder()
                .build();
    }

    @Bean
    public Function<PoliceDivisionEntityConverter.Wrapper, PoliceDivisionEntity> policeDivisionEntityConverter() {
        return PoliceDivisionEntityConverter.builder()
                .build();
    }

    @Bean
    public Function<Police, PoliceEntity> policeEntityConverter(
            Function<Parameter, ParameterEntity> parameterEntityConverter) {
        return PoliceEntityConverter.builder()
                .parameterEntityConverter(parameterEntityConverter)
                .build();
    }

    @Bean
    public Function<Situation, SituationEntity> situationEntityConverter(
            Function<Police, PoliceEntity> policeEntityConverter,
            Function<Parameter, ParameterEntity> parameterEntityConverter,
            Function<Division, DivisionEntity> divisionEntityConverter) {
        return SituationEntityConverter.builder()
                .policeEntityConverter(policeEntityConverter)
                .parameterEntityConverter(parameterEntityConverter)
                .divisionEntityConverter(divisionEntityConverter)
                .build();
    }


    /**
     * Output Jpa Converter Beans
     */

    @Bean
    public Function<DivisionEntity, Division> divisionConverter() {
        return DivisionConverter.builder()
                .build();
    }

    @Bean
    public Function<IdentityDocumentEntity, IdentityDocument> identityDocumentConverter(
            Function<ParameterEntity, Parameter> parameterConverter) {
        return IdentityDocumentConverter.builder()
                .parameterConverter(parameterConverter)
                .build();
    }

    @Bean
    public Function<PageResponseConverter.Wrapper, PageResponse> pageResponseConverter() {
        return PageResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<ParameterEntity, Parameter> parameterConverter() {
        return ParameterConverter.builder()
                .build();
    }

    @Bean
    public Function<PoliceEntity, Police> policeConverter(Function<ParameterEntity, Parameter> parameterConverter,
                                                          Function<DivisionEntity, Division> divisionConverter) {
        return PoliceConverter.builder()
                .parameterConverter(parameterConverter)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public Function<PoliceEntity, PolicePagedListItemResponse> policePagedListItemResponseConverter(
            Function<IdentityDocumentEntity, IdentityDocument> identityDocumentConverter,
            Function<DivisionEntity, Division> divisionConverter) {
        return PolicePagedListItemResponseConverter.builder()
                .identityDocumentConverter(identityDocumentConverter)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public Function<Page<PoliceEntity>, PolicePagedListResponse> policePagedListResponseConverter(
            Function<PageResponseConverter.Wrapper, PageResponse> pageResponseConverter,
            Function<PoliceEntity, PolicePagedListItemResponse> policePagedListItemResponseConverter) {
        return PolicePagedListResponseConverter.builder()
                .pageResponseConverter(pageResponseConverter)
                .policePagedListItemResponseConverter(policePagedListItemResponseConverter)
                .build();
    }

    @Bean
    public Function<SituationEntity, Situation> situationConverter(
            Function<PoliceEntity, Police> policeConverter,
            Function<ParameterEntity, Parameter> parameterConverter,
            Function<DivisionEntity, Division> divisionConverter) {
        return SituationConverter.builder()
                .policeConverter(policeConverter)
                .parameterConverter(parameterConverter)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public Function<SituationEntity, SituationPagedListItemResponse> situationPagedListItemResponseConverter(
            Function<ParameterEntity, Parameter> parameterConverter,
            Function<DivisionEntity, Division> divisionConverter) {
        return SituationPagedListItemResponseConverter.builder()
                .parameterConverter(parameterConverter)
                .divisionConverter(divisionConverter)
                .build();
    }

    @Bean
    public Function<Page<SituationEntity>, SituationPagedListResponse> situationPagedListResponseConverter(
            Function<PageResponseConverter.Wrapper, PageResponse> pageResponseConverter,
            Function<SituationEntity, SituationPagedListItemResponse> situationPagedListItemResponseConverter) {
        return SituationPagedListResponseConverter.builder()
                .pageResponseConverter(pageResponseConverter)
                .situationPagedListItemResponseConverter(situationPagedListItemResponseConverter)
                .build();
    }


    /**
     * Jpa Specification Beans
     */

    @Bean
    public PoliceEntitySpecification policeEntitySpecification() {
        return PoliceEntitySpecification.builder()
                .build();
    }

}
