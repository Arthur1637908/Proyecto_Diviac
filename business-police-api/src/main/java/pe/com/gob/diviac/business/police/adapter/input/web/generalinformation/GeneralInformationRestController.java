package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;
import java.util.function.Function;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.converter.update.request.UpdateGeneralInformationRestRequestConverter;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.detail.response.GeneralInformationDetailRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.save.request.SaveGeneralInformationRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.save.response.SaveGeneralInformationRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.update.request.UpdateGeneralInformationRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.update.response.UpdateGeneralInformationRestResponse;
import pe.com.gob.diviac.business.police.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.business.police.domain.port.input.GeneralInformationUseCase;
import pe.com.gob.diviac.business.police.entity.Police;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/polices/general-information")
@Tag(name = "General Information", description = "General Information Controller")
public class GeneralInformationRestController {

    private final GeneralInformationUseCase generalInformationUseCase;
    private final Function<SaveGeneralInformationRestRequest, Police> saveGeneralInformationRestRequestConverter;
    private final Function<UpdateGeneralInformationRestRequestConverter.Wrapper, Police> updateGeneralInformationRestRequestConverter;
    private final Function<Police, GeneralInformationDetailRestResponse> generalInformationDetailRestResponseConverter;
    private final Function<Police, SaveGeneralInformationRestResponse> saveGeneralInformationRestResponseConverter;
    private final Function<Police, UpdateGeneralInformationRestResponse> updateGeneralInformationRestResponseConverter;

    @GetMapping(value = "/{policeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get police general information", description = "Get police general information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = GeneralInformationDetailRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public GeneralInformationDetailRestResponse getPoliceGeneralInformationDetail(
            @PathVariable("policeId") UUID policeId) {
        Police police;
        GeneralInformationDetailRestResponse generalInformationDetailRestResponse;

        log.info("Starting GeneralInformationRestController.getPoliceGeneralInformationDetail");
        police = generalInformationUseCase.getPoliceGeneralInformationDetail(policeId);
        generalInformationDetailRestResponse = generalInformationDetailRestResponseConverter.apply(police);
        log.info("Finish GeneralInformationRestController.getPoliceGeneralInformationDetail successfully");

        return generalInformationDetailRestResponse;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save police general information", description = "Save police general information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = SaveGeneralInformationRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public SaveGeneralInformationRestResponse savePoliceGeneralInformation(
            @Valid @RequestBody SaveGeneralInformationRestRequest saveGeneralInformationRestRequest) {
        Police policeToSave;
        Police policeSaved;
        SaveGeneralInformationRestResponse saveGeneralInformationRestResponse;

        log.info("Starting GeneralInformationRestController.savePoliceGeneralInformation");
        policeToSave = saveGeneralInformationRestRequestConverter.apply(saveGeneralInformationRestRequest);
        policeSaved = generalInformationUseCase.savePoliceGeneralInformation(policeToSave);
        saveGeneralInformationRestResponse = saveGeneralInformationRestResponseConverter.apply(policeSaved);
        log.info("Finish GeneralInformationRestController.savePoliceGeneralInformation successfully");

        return saveGeneralInformationRestResponse;
    }

    @PutMapping(value = "/{policeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update police general information", description = "Update police general information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = UpdateGeneralInformationRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public UpdateGeneralInformationRestResponse updatePoliceGeneralInformation(@PathVariable("policeId") UUID policeId,
            @Valid @RequestBody UpdateGeneralInformationRestRequest updateGeneralInformationRestRequest) {
        Police policeToUpdate;
        Police policeUpdated;
        UpdateGeneralInformationRestResponse updateGeneralInformationRestResponse;

        log.info("Starting GeneralInformationRestController.updatePoliceGeneralInformation");
        policeToUpdate = updateGeneralInformationRestRequestConverter.apply(
                UpdateGeneralInformationRestRequestConverter.Wrapper.builder()
                        .policeId(policeId).updateGeneralInformationRestRequest(updateGeneralInformationRestRequest)
                        .build());
        policeUpdated = generalInformationUseCase.updateGeneralInformation(policeToUpdate);
        updateGeneralInformationRestResponse = updateGeneralInformationRestResponseConverter.apply(policeUpdated);
        log.info("Finish GeneralInformationRestController.updatePoliceGeneralInformation successfully");

        return updateGeneralInformationRestResponse;
    }
}
