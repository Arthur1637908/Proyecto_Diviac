package pe.com.gob.diviac.business.police.adapter.input.web.situation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.function.Function;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gob.diviac.business.police.adapter.input.web.situation.converter.update.request.UpdateSituationRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.request.SituationPagedListRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.response.SituationPagedListRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.request.SaveSituationRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.save.response.SaveSituationRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.update.request.UpdateSituationRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.situation.model.update.response.UpdateSituationRestResponse;
import pe.com.gob.diviac.business.police.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.business.police.domain.port.input.SituationUseCase;
import pe.com.gob.diviac.business.police.entity.Situation;
import pe.com.gob.diviac.business.police.entity.request.SituationPagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.SituationPagedListResponse;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/polices/situations")
@Tag(name = "Situation", description = "Situation Controller")
public class SituationController {

    private final SituationUseCase situationUseCase;
    private final Function<SituationPagedListRestRequest, SituationPagedListRequest> situationPagedListRequestConverter;
    private final Function<SaveSituationRestRequest, Situation> saveSituationRestRequestConverter;
    private final Function<UpdateSituationRestRequestConverter.Wrapper, Situation> updateSituationRestRequestConverter;
    private final Function<SituationPagedListResponse, SituationPagedListRestResponse> situationPagedListRestResponseConverter;
    private final Function<Situation, SaveSituationRestResponse> saveSituationRestResponseConverter;
    private final Function<Situation, UpdateSituationRestResponse> updateSituationRestResponseConverter;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List police situations", description = "List police situation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = SituationPagedListRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public SituationPagedListRestResponse findSituationsByFilters(
            @Valid SituationPagedListRestRequest situationPagedListRestRequest) {
        SituationPagedListRequest situationPagedListRequest;
        SituationPagedListResponse situationPagedListResponse;
        SituationPagedListRestResponse situationPagedListRestResponse;

        log.info("Starting SituationController.findSituationsByFilters");
        situationPagedListRequest = situationPagedListRequestConverter.apply(situationPagedListRestRequest);
        situationPagedListResponse = situationUseCase.findSituationsByFilters(situationPagedListRequest);
        situationPagedListRestResponse = situationPagedListRestResponseConverter.apply(situationPagedListResponse);
        log.info("Finish SituationController.findSituationsByFilters successfully");

        return situationPagedListRestResponse;
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save police situation", description = "Save police situation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = SaveSituationRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public SaveSituationRestResponse saveSituation(
            @Valid @ModelAttribute SaveSituationRestRequest saveSituationRestRequest) {
        Situation situationToSave;
        Situation situationSaved;
        SaveSituationRestResponse saveSituationRestResponse;

        log.info("Starting SituationController.saveSituation");
        situationToSave = saveSituationRestRequestConverter.apply(saveSituationRestRequest);
        situationSaved = situationUseCase.saveSituation(situationToSave);
        saveSituationRestResponse = saveSituationRestResponseConverter.apply(situationSaved);
        log.info("Finish SituationController.saveSituation successfully");

        return saveSituationRestResponse;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update police situation", description = "Update police situation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = UpdateSituationRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public UpdateSituationRestResponse updateSituation(
            @PathVariable Long id, @Valid @ModelAttribute UpdateSituationRestRequest updateSituationRestRequest) {
        Situation situationToUpdate;
        Situation situationUpdated;
        UpdateSituationRestResponse updateSituationRestResponse;

        log.info("Starting SituationController.updateSituation");
        situationToUpdate = updateSituationRestRequestConverter.apply(
                UpdateSituationRestRequestConverter.Wrapper.builder()
                        .situationId(id).updateSituationRestRequest(updateSituationRestRequest)
                        .build());
        situationUpdated = situationUseCase.updateSituation(situationToUpdate);
        updateSituationRestResponse = updateSituationRestResponseConverter.apply(situationUpdated);
        log.info("Finish SituationController.updateSituation successfully");

        return updateSituationRestResponse;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete police situation", description = "Delete police situation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = UpdateSituationRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public void deleteSituation(@PathVariable Long id) {
        log.info("Starting SituationController.deleteSituation");
        situationUseCase.deleteSituation(id);
        log.info("Finish SituationController.deleteSituation successfully");
    }
}
