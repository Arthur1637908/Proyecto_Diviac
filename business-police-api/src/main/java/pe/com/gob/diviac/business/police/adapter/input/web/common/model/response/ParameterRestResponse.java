package pe.com.gob.diviac.business.police.adapter.input.web.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "ParameterResponseBusiness")
public class ParameterRestResponse {

    @Schema(description = "Identifier", example = "1")
    private Integer id;

    @Schema(description = "Name", example = "PARAMETER_NAME")
    private String name;

    @Schema(description = "State", example = "true")
    private Boolean state;
}
