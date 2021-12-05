package pe.com.gob.diviac.business.division.util.exception;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;

@Getter
@Setter
public class DiviacStatusException extends RuntimeException {

    private HttpStatus status;
    private String errorCode;
    private String errorDescription;

    public DiviacStatusException(HttpStatus status, String errorCode, String errorDescription) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
