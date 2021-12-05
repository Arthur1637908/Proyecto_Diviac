package pe.com.gob.diviac.channel.parameter.application.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import pe.com.gob.diviac.channel.parameter.util.ErrorConstans;

import javax.validation.ValidationException;

@ControllerAdvice
@ResponseBody
public class ErrorConfiguration {

    @ExceptionHandler({IllegalArgumentException.class, ValidationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorInformation methodRequestNotValidException(
            Exception ex, WebRequest request) {
        return new ErrorInformation(
                ErrorConstans.ERROR_INVALID_REQUEST_CODE,
                ErrorConstans.ERROR_INVALID_REQUEST_DESCRIPTION);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInformation methodInternalErrorValidException(
            Exception ex, WebRequest request) {

        return new ErrorInformation(
                ErrorConstans.ERROR_INTERNAL_SERVER_CODE,
                ErrorConstans.ERROR_INTERNAL_SERVER_DESCRIPTION);

    }

}
