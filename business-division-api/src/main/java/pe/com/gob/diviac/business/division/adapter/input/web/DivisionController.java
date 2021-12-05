package pe.com.gob.diviac.business.division.adapter.input.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import pe.com.gob.diviac.business.division.adapter.input.web.converter.update.request.UpdateDivisionRestRequestConverter;
import pe.com.gob.diviac.business.division.adapter.input.web.model.common.request.DivisionRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.detail.response.DivisionDetailRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.request.DivisionsListRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.list.response.DivisionsListRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.save.request.SaveDivisionRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.save.response.SaveDivisionRestResponse;
import pe.com.gob.diviac.business.division.adapter.input.web.model.update.request.UpdateDivisionRestRequest;
import pe.com.gob.diviac.business.division.adapter.input.web.model.update.response.UpdateDivisionRestResponse;
import pe.com.gob.diviac.business.division.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.business.division.domain.port.input.DivisionUseCase;
import pe.com.gob.diviac.business.division.entity.Division;
import pe.com.gob.diviac.business.division.entity.request.DivisionsListRequest;
import pe.com.gob.diviac.business.division.entity.response.DivisionsListResponse;

import javax.validation.Valid;

@Validated
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/divisions")
@Tag(name = "Division", description = "Division Controller")
public class DivisionController {

    private final DivisionUseCase divisionUseCase;
    private final Function<DivisionsListRestRequest, DivisionsListRequest> divisionsListRestRequestConverter;
    private final Function<DivisionsListResponse, DivisionsListRestResponse> divisionsListRestResponseConverter;
    private final Function<Division, DivisionDetailRestResponse> divisionDetailRestResponseConverter;
    private final Function<SaveDivisionRestRequest, Division> saveDivisionRestRequestDivisionConverter;
    private final Function<Division, SaveDivisionRestResponse> saveDivisionRestResponseConverter;
    private final Function<UpdateDivisionRestRequestConverter.Wrapper, Division> updateDivisionRestRequestConverter;
    private final Function<Division, UpdateDivisionRestResponse> updateDivisionRestResponseConverter;


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get division by code or name", description = "Get division by code or name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = DivisionsListRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public DivisionsListRestResponse getDivisionList(@Valid DivisionsListRestRequest divisionsListRestRequest) {
        DivisionsListRequest divisionsListRequest;
        DivisionsListResponse divisionsListResponse;
        DivisionsListRestResponse divisionsListRestResponse;

        log.info("Starting DivisionController.getDivisionList");

        divisionsListRequest = divisionsListRestRequestConverter.apply(divisionsListRestRequest);
        divisionsListResponse = divisionUseCase.findAllByCodeAndName(divisionsListRequest);
        divisionsListRestResponse = divisionsListRestResponseConverter.apply(divisionsListResponse);

        log.info("Finish DivisionController.getDivisionList successfully");

        return divisionsListRestResponse;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get division", description = "Get division by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = DivisionDetailRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public DivisionDetailRestResponse getDivision(@PathVariable UUID id) {
        Division division;
        DivisionDetailRestResponse divisionDetailRestResponse;

        log.info("Starting DivisionController.getDivision");

        division = divisionUseCase.findById(id);
        divisionDetailRestResponse = divisionDetailRestResponseConverter.apply(division);

        log.info("Finish DivisionController.getDivision successfully");

        return divisionDetailRestResponse;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Post division", description = "Create division")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = SaveDivisionRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public SaveDivisionRestResponse insertDivision(@Valid @RequestBody SaveDivisionRestRequest saveDivisionRestRequest) {
        Division divisionToSave;
        Division divisionSaved;
        SaveDivisionRestResponse saveDivisionRestResponse;

        log.info("Starting DivisionController.insertDivision");
        divisionToSave = saveDivisionRestRequestDivisionConverter.apply(saveDivisionRestRequest);
        divisionSaved = divisionUseCase.insert(divisionToSave);
        saveDivisionRestResponse = saveDivisionRestResponseConverter.apply(divisionSaved);

        log.info("Finish DivisionController.insertDivision successfully");

        return saveDivisionRestResponse;

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Put division", description = "Update division")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = UpdateDivisionRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public UpdateDivisionRestResponse updateDivision(
            @PathVariable UUID id, @Valid @RequestBody UpdateDivisionRestRequest updateDivisionRestRequest) {
        Division divisionToUpdate;
        Division divisionUpdated;
        UpdateDivisionRestResponse updateDivisionRestResponse;

        log.info("Starting DivisionController.updateDivision");

        divisionToUpdate = updateDivisionRestRequestConverter.apply(UpdateDivisionRestRequestConverter.Wrapper
                .builder()
                .divisionId(id).updateDivisionRestRequest(updateDivisionRestRequest)
                .build());
        divisionUpdated = divisionUseCase.update(divisionToUpdate);
        updateDivisionRestResponse = updateDivisionRestResponseConverter.apply(divisionUpdated);

        log.info("Finish DivisionController.updateDivision successfully");

        return updateDivisionRestResponse;

    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete division", description = "Delete division")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public void deleteDivision(@PathVariable UUID id) {
        log.info("Starting DivisionController.deleteDivision");

        divisionUseCase.delete(id);

        log.info("Finish DivisionController.deleteDivision successfully");

    }

}
