package pe.com.gob.diviac.business.police.adapter.input.web.situation.model.list.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "SituationPagedListRequestBusiness")
public class SituationPagedListRestRequest {

    @NotNull
    @Schema(description = "Police identifier", example = "7a477b04-da45-4d69-8216-4669cf39977d")
    private UUID policeId;

    @Min(1)
    @NotNull
    @Schema(description = "Current page", example = "1")
    private Integer currentPage;

    @Min(1)
    @NotNull
    @Schema(description = "Page size", example = "10")
    private Integer pageSize;
}
