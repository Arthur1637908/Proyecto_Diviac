package pe.com.gob.diviac.business.police.adapter.input.web.common.model.response;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "DivisionResponseBusiness")
public class DivisionRestResponse {

    @Schema(description = "Identifier", example = "67ad327e-7e4b-463b-b6de-200c9c9fe530")
    private UUID id;

    @Schema(description = "Name", example = "DIVISION LOS OLIVOS")
    private String name;
}
