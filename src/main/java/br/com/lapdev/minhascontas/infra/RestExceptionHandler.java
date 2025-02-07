package br.com.lapdev.minhascontas.infra;

import br.com.lapdev.minhascontas.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }
}
