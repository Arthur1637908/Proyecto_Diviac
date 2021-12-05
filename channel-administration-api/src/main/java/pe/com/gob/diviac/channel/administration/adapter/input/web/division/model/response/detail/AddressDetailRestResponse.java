package pe.com.gob.diviac.channel.administration.adapter.input.web.division.model.response.detail;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDetailRestResponse {

    @Schema(description = "Identifier", example = "1")
    private Long id;

    @Schema(description = "Name", example = "Los Tulipanes")
    private String name;

    @Schema(description = "Number", example = "424")
    private String number;

    @Schema(description = "Type identifier", example = "1")
    private Integer typeId;

    @Schema(description = "District information", example = "1")
    private Integer districtId;

    @Schema(description = "Province information", example = "1")
    private Integer provinceId;

    @Schema(description = "Department information", example = "1")
    private Integer departmentId;
}
