package pe.com.gob.diviac.business.police.adapter.input.web.police;

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

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.request.PolicePagedListRestRequest;
import pe.com.gob.diviac.business.police.adapter.input.web.police.model.list.response.PolicePagedListRestResponse;
import pe.com.gob.diviac.business.police.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.business.police.domain.port.input.PoliceUseCase;
import pe.com.gob.diviac.business.police.entity.request.PolicePagedListRequest;
import pe.com.gob.diviac.business.police.entity.response.PolicePagedListResponse;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/polices")
@Tag(name = "Polices", description = "Police Controller")
public class PoliceRestController {

    private final PoliceUseCase policeUseCase;
    private final Function<PolicePagedListRestRequest, PolicePagedListRequest> policePagedListRestRequestConverter;
    private final Function<PolicePagedListResponse, PolicePagedListRestResponse> policePagedListRestResponseConverter;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get polices by filters", description = "Get polices by filters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = PolicePagedListRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public PolicePagedListRestResponse findPoliceByFilters(@Valid PolicePagedListRestRequest policePagedListRestRequest) {
        PolicePagedListRequest policePagedListRequest;
        PolicePagedListResponse policePagedListResponse;
        PolicePagedListRestResponse policePagedListRestResponse;

        log.info("Starting PoliceRestController.findPoliceByFilters");
        policePagedListRequest = policePagedListRestRequestConverter.apply(policePagedListRestRequest);
        policePagedListResponse = policeUseCase.findPoliceByFilters(policePagedListRequest);
        policePagedListRestResponse = policePagedListRestResponseConverter.apply(policePagedListResponse);
        log.info("Finish PoliceRestController.findPoliceByFilters successfully");

        return policePagedListRestResponse;
    }

    @DeleteMapping(value = "/{policeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Logical elimination of a police", description = "Logical elimination of a police")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public ResponseEntity<?> deletePolice(@PathVariable("policeId") UUID id) {

        log.info("Starting PoliceRestController.deletePolice");
        policeUseCase.deletePolice(id);
        log.info("Finish PoliceRestController.deletePolice successfully");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
