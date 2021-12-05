package pe.com.gob.diviac.business.police.application.errorhandling;

import java.time.format.DateTimeParseException;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Slf4j
@ResponseBody
@RestControllerAdvice
public class ErrorConfiguration {

    @ExceptionHandler({BindException.class, MissingServletRequestParameterException.class, TypeMismatchException.class,
            MethodArgumentNotValidException.class, NoHandlerFoundException.class, HttpMessageNotReadableException.class,
            DateTimeParseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInformation handleBadRequestException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        return ErrorInformation.resolve(ErrorConstants.ERROR_INVALID_REQUEST_CODE,
                ErrorConstants.ERROR_INVALID_REQUEST_DESCRIPTION);
    }

    @ExceptionHandler({DiviacStatusException.class})
    public ResponseEntity<ErrorInformation> handleDiviacStatusException(DiviacStatusException ex) {
        log.error(ex.getMessage(), ex);

        ErrorInformation errorInformation = ErrorInformation.resolve(ex.getErrorCode(), ex.getErrorDescription());
        return new ResponseEntity<>(errorInformation, ex.getStatus());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInformation handleInternalServerError(Exception ex, HttpServletResponse httpServletResponse) {
        log.error(ex.getMessage(), ex);

        return ErrorInformation.resolve(ErrorConstants.ERROR_INTERNAL_SERVER_CODE,
                ErrorConstants.ERROR_INTERNAL_SERVER_DESCRIPTION);
    }
}

