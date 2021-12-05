package pe.com.gob.diviac.channel.administration.adapter.input.web.division;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.converter.request.update.UpdateDivisionRestRequestConverter;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.list.DivisionListRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.save.SaveDivisionRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.request.update.UpdateDivisionRestRequest;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.DivisionDetailRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.list.DivisionListRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.update.UpdateDivisionRestResponse;
import pe.com.gob.diviac.channel.administration.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.channel.administration.domain.port.input.DivisionUseCase;
import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.request.DivisionListRequest;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/divisions")
@Tag(name = "Divisions", description = "Division Controller")
public class DivisionController {

    private final DivisionUseCase divisionUseCase;

    private final Function<DivisionListRestRequest, DivisionListRequest> divisionListRestRequestConverter;
    private final Function<SaveDivisionRestRequest, Division> saveDivisionRestRequestConverter;
    private final Function<UpdateDivisionRestRequestConverter.Wrapper, Division> updateDivisionRestRequestConverter;

    private final Function<DivisionListResponse, DivisionListRestResponse> divisionListRestResponseConverter;
    private final Function<Division, DivisionDetailRestResponse> divisionDetailRestResponseConverter;
    private final Function<Division, UpdateDivisionRestResponse> updateDivisionRestResponseConverter;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List divisions by code and name", description = "List divisions by code and name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = DivisionListRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public DivisionListRestResponse listDivisionsByCodeAndName(@Valid DivisionListRestRequest divisionListRestRequest) {
        DivisionListResponse divisionListResponse;
        DivisionListRestResponse divisionListRestResponse;

        log.info("Starting DivisionController.listDivisionsByCodeAndName");
        divisionListResponse = divisionUseCase.listDivisionsByCodeAndName(divisionListRestRequestConverter
                .apply(divisionListRestRequest));
        divisionListRestResponse = divisionListRestResponseConverter.apply(divisionListResponse);
        log.info("Finish DivisionController.listDivisionsByCodeAndName successfully");

        return divisionListRestResponse;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get division detail", description = "Get division detail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = DivisionDetailRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public DivisionDetailRestResponse getDivisionDetail(@PathVariable("id") UUID id) {
        Division division;
        DivisionDetailRestResponse divisionDetailRestResponse;

        log.info("Starting DivisionController.getDivisionDetail");
        division = divisionUseCase.getDivisionDetail(id);
        divisionDetailRestResponse = divisionDetailRestResponseConverter.apply(division);
        log.info("Finish DivisionController.getDivisionDetail successfully");

        return divisionDetailRestResponse;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save a new division", description = "Save a new division")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public void save(@RequestBody @Valid SaveDivisionRestRequest saveDivisionRestRequest) {
        log.info("Starting DivisionController.save");
        divisionUseCase.save(saveDivisionRestRequestConverter.apply(saveDivisionRestRequest));
        log.info("Finish DivisionController.save successfully");
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a division", description = "Update a division")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = UpdateDivisionRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public UpdateDivisionRestResponse update(@PathVariable("id") UUID id,
                                             @RequestBody @Valid UpdateDivisionRestRequest updateDivisionRestRequest) {
        Division division;
        UpdateDivisionRestRequestConverter.Wrapper wrapper;
        UpdateDivisionRestResponse updateDivisionRestResponse;

        log.info("Starting DivisionController.update");
        wrapper = UpdateDivisionRestRequestConverter.Wrapper.builder()
                .id(id).updateDivisionRestRequest(updateDivisionRestRequest).build();
        division = divisionUseCase.update(updateDivisionRestRequestConverter.apply(wrapper));
        updateDivisionRestResponse = updateDivisionRestResponseConverter.apply(division);
        log.info("Finish DivisionController.update successfully");

        return updateDivisionRestResponse;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a division", description = "Delete a division")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public void delete(@PathVariable("id") UUID id) {
        log.info("Starting DivisionController.delete");
        divisionUseCase.delete(id);
        log.info("Finish DivisionController.update successfully");
    }

}
