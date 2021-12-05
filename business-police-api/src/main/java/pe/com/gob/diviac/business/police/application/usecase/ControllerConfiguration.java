package pe.com.gob.diviac.business.police.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response.ParameterRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response.PoliceRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PoliceRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.detail.response.GeneralInformationDetailRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.save.request.SaveGeneralInformationRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.save.response.SaveGeneralInformationRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.update.request.UpdateGeneralInformationRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.update.response.UpdateGeneralInformationRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.detail.response.GeneralInformationDetailRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.save.request.SaveGeneralInformationRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.save.response.SaveGeneralInformationRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.update.response.UpdateGeneralInformationRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.list.response.IdentityDocumentItemRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.save.request.SaveIdentityDocumentRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.save.response.SaveIdentityDocumentRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.update.request.UpdateIdentityDocumentRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.converter.update.response.UpdateIdentityDocumentRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.list.response.IdentityDocumentItemRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.save.request.SaveIdentityDocumentRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.save.response.SaveIdentityDocumentRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.update.request.UpdateIdentityDocumentRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.update.response.UpdateIdentityDocumentRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.police.converter.list.request.PolicePagedListRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response.DivisionRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.common.converter.response.PageRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.police.converter.list.response.PolicePagedListItemRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.police.converter.list.response.PolicePagedListRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.request.PolicePagedListRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.identitydocument.model.common.response.IdentityDocumentRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.PageRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.response.PolicePagedListItemRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.response.PolicePagedListRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.list.request.SituationPagedListRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.list.response.SituationPagedListItemRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.list.response.SituationPagedListRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.save.request.SaveSituationRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.save.response.SaveSituationRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.update.request.UpdateSituationRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.update.response.UpdateSituationRestResponseConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.request.SituationPagedListRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response.SituationPagedListItemRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response.SituationPagedListRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.request.SaveSituationRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.response.SaveSituationRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.update.response.UpdateSituationRestResponse;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.entity.IdentityDocument;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.entity.Police;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;
import pe.com.gob.diviac.business.police.entity.request.SituationPagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.PageResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListItemResponse;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

@Configuration
public class ControllerConfiguration {

    /**
     * Request Converter Beans - [COMMON]
     */

    //TODO: Add request converter beans

    /**
     * Response Converter Beans - [COMMON]
     */

    @Bean
    public Function<Division, DivisionRestResponse> divisionRestResponseConverter() {
        return DivisionRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<PageResponse, PageRestResponse> pageRestResponseConverter() {
        return PageRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Parameter, ParameterRestResponse> parameterRestResponseConverter() {
        return ParameterRestResponseConverter.builder()
                .build();
    }

    @Bean
    public Function<Police, PoliceRestResponse> policeRestResponseConverter() {
        return PoliceRestResponseConverter.builder()
                .build();
    }


    /**
     * Request Converter Beans - [GENERAL INFORMATION]
     */

    @Bean
    public Function<SaveGeneralInformationRestRequest, Police> saveGeneralInformationRestRequestConverter() {
        return SaveGeneralInformationRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<UpdateGeneralInformationRestRequestConverter.Wrapper, Police>
    updateGeneralInformationRestRequestConverter() {
        return UpdateGeneralInformationRestRequestConverter.builder()
                .build();
    }

    /**
     * Response Converter Beans - [GENERAL INFORMATION]
     */

    @Bean
    public Function<Police, GeneralInformationDetailRestResponse> generalInformationDetailRestResponseConverter(
            Function<Division, DivisionRestResponse> divisionRestResponseConverter,
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter) {
        return GeneralInformationDetailRestResponseConverter.builder()
                .divisionRestResponseConverter(divisionRestResponseConverter)
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .build();
    }

    @Bean
    public Function<Police, SaveGeneralInformationRestResponse> saveGeneralInformationRestResponseConverter(
            Function<Division, DivisionRestResponse> divisionRestResponseConverter,
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter) {
        return SaveGeneralInformationRestResponseConverter.builder()
                .divisionRestResponseConverter(divisionRestResponseConverter)
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .build();
    }

    @Bean
    public Function<Police, UpdateGeneralInformationRestResponse> updateGeneralInformationRestResponseConverter(
            Function<Division, DivisionRestResponse> divisionRestResponseConverter,
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter) {
        return UpdateGeneralInformationRestResponseConverter.builder()
                .divisionRestResponseConverter(divisionRestResponseConverter)
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .build();
    }


    /**
     * Request Converter Beans - [IDENTITY DOCUMENT]
     */

    @Bean
    public Function<SaveIdentityDocumentRestRequest, IdentityDocument> saveIdentityDocumentRequestConverter(){
        return SaveIdentityDocumentRestRequestConverter.builder().build();
    }

    @Bean
    public Function<UpdateIdentityDocumentRestRequestConverter.Wrapper, IdentityDocument>
    updateIdentityDocumentRequestConverter() {
        return UpdateIdentityDocumentRestRequestConverter.builder().build();
    }

    /**
     * Response Converter Beans - [IDENTITY DOCUMENT]
     */

    @Bean
    public Function<IdentityDocument, IdentityDocumentItemRestResponse> identityDocumentItemRestResponseConverter(
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter) {
        return IdentityDocumentItemRestResponseConverter.builder()
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .build();
    }

    @Bean
    public Function<IdentityDocument, SaveIdentityDocumentRestResponse> saveIdentityDocumentRestResponseConverter(
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter) {
        return SaveIdentityDocumentRestResponseConverter.builder()
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .build();
    }

    @Bean
    public Function<IdentityDocument, UpdateIdentityDocumentRestResponse> updateIdentityDocumentRestResponseConverter(
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter) {
        return UpdateIdentityDocumentRestResponseConverter.builder()
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .build();
    }


    /**
     * Request Converter Beans - [POLICE]
     */

    @Bean
    public Function<PolicePagedListRestRequest, PolicePagedListRequest> policePagedListRestRequestConverter() {
        return PolicePagedListRestRequestConverter.builder()
                .build();
    }

    /**
     * Response Converter Beans - [POLICE]
     */

    @Bean
    public Function<PolicePagedListItemResponse, PolicePagedListItemRestResponse>
    policePagedListItemRestResponseConverter(Function<Division, DivisionRestResponse> divisionRestResponseConverter) {
        return PolicePagedListItemRestResponseConverter.builder()
                .divisionRestResponseConverter(divisionRestResponseConverter)
                .build();
    }

    @Bean
    public Function<PolicePagedListResponse, PolicePagedListRestResponse> policePagedListRestResponseConverter(
            Function<PageResponse, PageRestResponse> pageRestResponseConverter,
            Function<PolicePagedListItemResponse, PolicePagedListItemRestResponse> pagedListItemRestResponseConverter) {
        return PolicePagedListRestResponseConverter.builder()
                .pageRestResponseConverter(pageRestResponseConverter)
                .policePagedListItemRestResponseConverter(pagedListItemRestResponseConverter)
                .build();
    }

    /**
     * Request Converter Beans - [SITUATION]
     */

    @Bean
    public Function<SituationPagedListRestRequest, SituationPagedListRequest> situationPagedListRequestConverter() {
        return SituationPagedListRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<SaveSituationRestRequest, Situation> saveSituationRestRequestConverter() {
        return SaveSituationRestRequestConverter.builder()
                .build();
    }

    @Bean
    public Function<UpdateSituationRestRequestConverter.Wrapper, Situation> updateSituationRestRequestConverter() {
        return UpdateSituationRestRequestConverter.builder()
                .build();
    }

    /**
     * Response Converter Beans - [SITUATION]
     */

    @Bean
    public Function<SituationPagedListItemResponse, SituationPagedListItemRestResponse>
    situationPagedListItemRestResponseConverter(
                    Function<Parameter, ParameterRestResponse> parameterRestResponseConverter,
                    Function<Division, DivisionRestResponse> divisionRestResponseConverter) {
        return SituationPagedListItemRestResponseConverter.builder()
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .divisionRestResponseConverter(divisionRestResponseConverter)
                .build();
    }

    @Bean
    public Function<SituationPagedListResponse, SituationPagedListRestResponse>
    situationPagedListRestResponseConverter(Function<PageResponse, PageRestResponse> pageRestResponseConverter,
            Function<SituationPagedListItemResponse, SituationPagedListItemRestResponse>
                    situationPagedListItemRestResponseConverter) {
        return SituationPagedListRestResponseConverter.builder()
                .pageRestResponseConverter(pageRestResponseConverter)
                .situationPagedListItemRestResponseConverter(situationPagedListItemRestResponseConverter)
                .build();
    }

    @Bean
    public Function<Situation, SaveSituationRestResponse> saveSituationRestResponseConverter(
            Function<Police, PoliceRestResponse> policeRestResponseConverter,
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter,
            Function<Division, DivisionRestResponse> divisionRestResponseConverter) {
        return SaveSituationRestResponseConverter.builder()
                .policeRestResponseConverter(policeRestResponseConverter)
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .divisionRestResponseConverter(divisionRestResponseConverter)
                .build();
    }

    @Bean
    public Function<Situation, UpdateSituationRestResponse> updateSituationRestResponseConverter(
            Function<Police, PoliceRestResponse> policeRestResponseConverter,
            Function<Parameter, ParameterRestResponse> parameterRestResponseConverter,
            Function<Division, DivisionRestResponse> divisionRestResponseConverter) {
        return UpdateSituationRestResponseConverter.builder()
                .policeRestResponseConverter(policeRestResponseConverter)
                .parameterRestResponseConverter(parameterRestResponseConverter)
                .divisionRestResponseConverter(divisionRestResponseConverter)
                .build();
    }
}
