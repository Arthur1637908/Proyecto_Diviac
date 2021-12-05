package pe.com.gob.diviac.business.division.adapter.input.web.model.common.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class DivisionRestResponse {

    @Schema(description = "Division identifier", example = "c7112e0d-e6c9-44bd-b4fa-736f53af0c32")
    private UUID id;

    @Schema(description = "Code", example = "DIV0001")
    private String code;

    @Schema(description = "Acronym", example = "SGL")
    private String acronym;

    @Schema(description = "Name", example = "SAN JUAN")
    private String name;

    @Schema(description = "Description", example = "DIVISION UBICADA EN EL DISTRITO...")
    private String description;

    @Schema(name = "Address information")
    private AddressRestResponse address;

    @Schema(name = "Contact information")
    private ContactRestResponse contact;
}
