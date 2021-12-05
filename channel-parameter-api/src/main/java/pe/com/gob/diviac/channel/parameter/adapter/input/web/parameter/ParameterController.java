package pe.com.gob.diviac.channel.parameter.adapter.input.web.parameter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gob.diviac.channel.parameter.adapter.input.web.parameter.model.response.ParameterRestResponse;
import pe.com.gob.diviac.channel.parameter.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.channel.parameter.domain.port.input.ParameterUseCase;
import pe.com.gob.diviac.channel.parameter.entity.Parameter;
import pe.com.gob.diviac.channel.parameter.util.ValidationConstants;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/parameters")
@Tag(name = "Parameters", description = "Parameter Controller")
public class ParameterController {

    private final ParameterUseCase parameterUseCase;
    private final Function<Parameter, ParameterRestResponse> parameterRestResponseConverter;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get parameters by groupCode", description = "Get parameters by groupCode")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = ParameterRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public List<ParameterRestResponse> findParametersByGroupCode(@RequestParam @NotNull
            @Pattern(regexp = ValidationConstants.REGEX_CODE_GROUP) String groupCode) {
        List<ParameterRestResponse> parameterRestResponseList;

        log.info("Starting ParameterController.findParametersByGroupCode");
        parameterRestResponseList = parameterUseCase.findByGroupCode(groupCode)
                .stream()
                .map(parameterRestResponseConverter)
                .sorted(Comparator.comparing(ParameterRestResponse::getName))
                .collect(Collectors.toList());
        log.info("Finish ParameterController.findParametersByGroupCode successfully");

        return parameterRestResponseList;
    }
}
