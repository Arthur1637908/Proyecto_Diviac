package pe.com.gob.diviac.business.division.application.errorhandling;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import pe.com.gob.diviac.business.division.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.division.util.exception.DiviacStatusException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ErrorConfiguration {

    @ExceptionHandler({IllegalArgumentException.class, ValidationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorInformation methodRequestNotValidException(
            Exception ex, WebRequest request) {

        log.error(ex.getMessage(), ex);

        return ErrorInformation.resolve(ErrorConstants.ERROR_INVALID_REQUEST_CODE,
                ErrorConstants.ERROR_INVALID_REQUEST_DESCRIPTION);
    }

    @ExceptionHandler({DiviacStatusException.class})
    public ResponseEntity<ErrorInformation> methodNotFoundValidException(DiviacStatusException ex) {
        log.error(ex.getMessage(), ex);

        ErrorInformation errorInformation = ErrorInformation.resolve(ex.getErrorCode(), ex.getErrorDescription());
        return new ResponseEntity<>(errorInformation, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInformation methodInternalErrorValidException(
            Exception ex, WebRequest request) {

        log.error(ex.getMessage(), ex);

        return ErrorInformation.resolve(ErrorConstants.ERROR_INTERNAL_SERVER_CODE,
                ErrorConstants.ERROR_INTERNAL_SERVER_DESCRIPTION);

    }

}
