package pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response.DepartmentRestResponse;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response.DistrictRestResponse;
import pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response.ProvinceRestResponse;
import pe.com.gob.diviac.channel.parameter.application.errorhandling.ErrorInformation;
import pe.com.gob.diviac.channel.parameter.domain.port.input.UbigeoUseCase;
import pe.com.gob.diviac.channel.parameter.entity.Department;
import pe.com.gob.diviac.channel.parameter.entity.District;
import pe.com.gob.diviac.channel.parameter.entity.Province;
import pe.com.gob.diviac.channel.parameter.util.ValidationConstants;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/ubigeos")
@Tag(name = "Ubigeos", description = "Ubigeo Controller")
public class UbigeoController {

    private final UbigeoUseCase ubigeoUseCase;

    private final Function<Department, DepartmentRestResponse> departmentRestResponseConverter;
    private final Function<Province, ProvinceRestResponse> provinceRestResponseConverter;
    private final Function<District, DistrictRestResponse> districtRestResponseConverter;

    @GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all departments", description = "Get all departments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = DepartmentRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public List<DepartmentRestResponse> findAllDepartments() {
        List<DepartmentRestResponse> departmentRestResponseList;

        log.info("Starting UbigeoController.findAllDepartments");
        departmentRestResponseList = ubigeoUseCase.findAllDepartments().stream()
                .map(departmentRestResponseConverter)
                .sorted(Comparator.comparing(DepartmentRestResponse::getName))
                .collect(Collectors.toList());
        log.info("Finish UbigeoController.findAllDepartments successfully");

        return departmentRestResponseList;
    }

    @GetMapping(value = "/provinces", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get provinces by departmentId", description = "Get provinces by departmentId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = ProvinceRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    public List<ProvinceRestResponse> findProvincesByIdDepartment(
            @RequestParam @NotNull
            @Min(value = ValidationConstants.MIN_VALUE_DEPARTMENT_ID)
            @Max(value = ValidationConstants.MAX_VALUE_DEPARTMENT_ID) Integer departmentId) {
        List<ProvinceRestResponse> provinceRestResponseList;

        log.info("Starting UbigeoController.findProvincesByIdDepartment");
        provinceRestResponseList = ubigeoUseCase.findProvincesByIdDepartment(departmentId).stream()
                .map(provinceRestResponseConverter)
                .sorted(Comparator.comparing(ProvinceRestResponse::getName))
                .collect(Collectors.toList());
        log.info("Finish UbigeoController.findProvincesByIdDepartment successfully");

        return provinceRestResponseList;
    }

    @Operation(summary = "Get districts by provinceId", description = "Get districts by provinceId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Already Ok",
                    content = {@Content(schema = @Schema(implementation = DistrictRestResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema(implementation = ErrorInformation.class))})
    })
    @GetMapping(value = "/districts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DistrictRestResponse> findDistrictsByIdProvince(
            @RequestParam @NotNull
            @Min(value = ValidationConstants.MIN_VALUE_PROVINCE_ID)
            @Max(value = ValidationConstants.MAX_VALUE_PROVINCE_ID)Integer provinceId) {
        List<DistrictRestResponse> districtRestResponseList;

        log.info("Starting UbigeoController.findDistrictsByIdProvince");
        districtRestResponseList = ubigeoUseCase.findDistrictsByIdProvince(provinceId).stream()
                .map(districtRestResponseConverter)
                .sorted(Comparator.comparing(DistrictRestResponse::getName))
                .collect(Collectors.toList());
        log.info("Starting UbigeoController.findDistrictsByIdProvince successfully");

        return districtRestResponseList;
    }
}
