package pe.com.gob.diviac.channel.parameter.adapter.input.web.ubigeo.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "DistrictBusinessResponse")
public class DistrictRestResponse {

    @Schema(description = "Identifier of the district", example = "1", required = true)
    private Integer id;

    @Schema(description = "Name of the district", example = "MAGDALENA", required = true)
    private String name;
    
}
