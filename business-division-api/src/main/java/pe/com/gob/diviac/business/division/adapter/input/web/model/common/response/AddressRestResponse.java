package pe.com.gob.diviac.business.division.adapter.input.web.model.common.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Schema(name = "AddressResponseBusiness")
public class AddressRestResponse {

    @Schema(description = "Address identifier", example = "1")
    private Long id;

    @Schema(name = "Address type information")
    private ParameterRestResponse type;

    @Schema(description = "Name", example = "MANUEL PRADO")
    private String name;

    @Schema(description = "Number", example = "123")
    private String number;

    @Schema(description = "Department information")
    private UbigeoRestResponse department;

    @Schema(description = "Province information")
    private UbigeoRestResponse province;

    @Schema(name = "District information")
    private UbigeoRestResponse district;
}
