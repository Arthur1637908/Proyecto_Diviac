package pe.com.gob.diviac.support.audit.producer.adapter.input.web.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pe.com.gob.diviac.support.audit.producer.util.enums.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AuditRequestSupport")
public class AuditRestRequest {

    @NotNull
    @Schema(description = "Transaction identifier", required = true)
    private UUID transactionId;

    @NotNull
    @NotBlank
    @Schema(description = "Application identifier", required = true)
    private String applicationId;

    @NotNull
    @NotBlank
    @Schema(description = "Application name", required = true)
    private String applicationName;

    @NotNull
    @NotBlank
    @Schema(description = "Police CIP", required = true)
    private String consumerId;

    @NotNull
    @NotBlank
    private String functionalActionCode;

    @NotNull
    @Schema(description = "Http Status", required = true)
    private HttpStatus httpStatus;

    @Schema(description = "Record before change")
    private String recordBeforeChange;

    @Schema(description = "Record after change")
    private String recordAfterChange;

}
