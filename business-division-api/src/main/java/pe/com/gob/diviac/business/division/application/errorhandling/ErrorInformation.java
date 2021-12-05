package pe.com.gob.diviac.business.division.application.errorhandling;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorInformation {

    @Schema(description = "Error code", example = "DV0001", required = true)
    private String errorCode;

    @Schema(description = "Description of the error", example = "Error when calling service", required = true)
    private String errorDescription;

    public static ErrorInformation resolve(String errorCode, String errorDescription) {
        return ErrorInformation.builder()
                .errorCode(errorCode)
                .errorDescription(errorDescription)
                .build();
    }

}
