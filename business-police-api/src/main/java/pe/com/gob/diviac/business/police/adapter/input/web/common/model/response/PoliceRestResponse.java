package pe.com.gob.diviac.business.police.adapter.input.web.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "PoliceResponseBusiness")
public class PoliceRestResponse {

    private UUID id;
    private String cip;
    private String names;
    private String lastNames;
}
