package pe.com.gob.diviac.channel.parameter.adapter.input.web.parameter.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "ParameterBusinessResponse")
public class ParameterRestResponse {

    @Schema(description = "Identifier of the parameter", example = "1", required = true)
    private Integer id;

    @Schema(description = "Name of the parameter", example = "Avenida", required = true)
    private String name;

}
