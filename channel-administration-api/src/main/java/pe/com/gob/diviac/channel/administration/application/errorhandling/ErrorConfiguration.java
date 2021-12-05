package pe.com.gob.diviac.channel.administration.application.errorhandling;

import feign.FeignException;

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

import pe.com.gob.diviac.channel.administration.utils.JsonUtils;
import pe.com.gob.diviac.channel.administration.utils.constants.ErrorConstants;

@Slf4j
@ResponseBody
@RestControllerAdvice
public class ErrorConfiguration {

    @ExceptionHandler({BindException.class, MissingServletRequestParameterException.class, TypeMismatchException.class,
            MethodArgumentNotValidException.class, NoHandlerFoundException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInformation handleBadRequestException(Exception ex) {
        log.error(ex.getMessage(), ex);
        
        return ErrorInformation.resolve(ErrorConstants.ERROR_INVALID_REQUEST_CODE,
                ErrorConstants.ERROR_INVALID_REQUEST_DESCRIPTION);
    }

    @ExceptionHandler({FeignException.class})
    public ResponseEntity<ErrorInformation> handleFeignException(FeignException ex) {
        ErrorInformation errorInformation;

        if (ex.status() < 0) {
            log.error(ex.getMessage(), ex);
            errorInformation = ErrorInformation.resolve(ErrorConstants.ERROR_CONNECT_TO_BUSINESS_API,
                    ErrorConstants.ERROR_CONNECT_TO_BUSINESS_API_DESCRIPTION);
            return new ResponseEntity<>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        errorInformation = JsonUtils.toObject(ex.contentUTF8(), ErrorInformation.class);

        if (errorInformation.getErrorCode().equals(ErrorConstants.ERROR_INTERNAL_SERVER_CODE)) {
            log.error(ex.getMessage(), ex);
        }

        return new ResponseEntity<>(errorInformation, HttpStatus.valueOf(ex.status()));
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInformation handleInternalServerError(Exception ex) {
        log.error(ex.getMessage(), ex);

        return ErrorInformation.resolve(ErrorConstants.ERROR_INTERNAL_SERVER_CODE,
                ErrorConstants.ERROR_INTERNAL_SERVER_DESCRIPTION);
    }
}

