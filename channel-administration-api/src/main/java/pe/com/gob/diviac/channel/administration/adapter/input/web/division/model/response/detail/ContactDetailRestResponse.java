package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactDetailRestResponse {

    @Schema(description = "Email", example = "example@abc.com")
    private String email;

    @Schema(description = "Phone number", example = "55555")
    private String phoneNumber;

    @Schema(description = "Annex number", example = "555")
    private String annexNumber;
}
