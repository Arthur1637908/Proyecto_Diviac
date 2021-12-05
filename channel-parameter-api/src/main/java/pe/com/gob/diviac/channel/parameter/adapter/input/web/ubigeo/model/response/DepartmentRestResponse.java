package pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "DepartmentBusinessResponse")
public class DepartmentRestResponse {

    @Schema(description = "Identifier of the department", example = "1", required = true)
    private Integer id;

    @Schema(description = "Name of the department", example = "LIMA", required = true)
    private String name;

}
