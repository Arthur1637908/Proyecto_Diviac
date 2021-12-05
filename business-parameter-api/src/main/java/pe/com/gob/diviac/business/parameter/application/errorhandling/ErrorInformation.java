package pe.com.gob.diviac.business.parameter.application.errorhandling;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorInformation {

    @Schema(description = "Error code", example = "DV0001", required = true)
    private String errorCode;

    @Schema(description = "Description of the error", example = "Error when calling service", required = true)
    private String errorDescription;

}
