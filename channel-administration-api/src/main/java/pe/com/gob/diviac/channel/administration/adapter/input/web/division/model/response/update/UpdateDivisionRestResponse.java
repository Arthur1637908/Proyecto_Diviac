package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.AddressDetailRestResponse;
import pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail.ContactDetailRestResponse;

@Getter
@Setter
@Builder
public class UpdateDivisionRestResponse {

    @Schema(description = "Identifier", example = "a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11")
    private String id;

    @Schema(description = "Code", example = "DIV01")
    private String code;

    @Schema(description = "Acronym", example = "DIVLO")
    private String acronym;

    @Schema(description = "Name", example = "División de Los Olivos")
    private String name;

    @Schema(description = "Description", example = "División con más de 10 años...")
    private String description;

    @Schema(description = "Address information")
    private AddressDetailRestResponse address;

    @Schema(description = "Contact information")
    private ContactDetailRestResponse contact;
}
