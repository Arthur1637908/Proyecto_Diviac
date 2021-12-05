package pe.com.gob.diviac.support.audit.consumer.util.enums;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpStatus implements Serializable {

    HTTP_200("200", "Ok"),
    HTTP_400("400", "Bad Request"),
    HTTP_401("401", "Unauthorized"),
    HTTP_500("500", "Internal Error");

    private final String code;
    private final String description;
}
