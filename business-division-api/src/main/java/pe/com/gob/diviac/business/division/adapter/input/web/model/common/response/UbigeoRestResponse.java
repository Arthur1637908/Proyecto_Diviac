package pe.com.gob.diviac.business.division.adapter.input.web.model.common.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "UbigeoResponseBusiness")
public class UbigeoRestResponse {

    @Schema(description = "Ubigeo identifier", example = "1")
    private Integer id;

    @Schema(description = "Name", example = "AMAZONAS")
    private String name;
}
