package inforest.reversegeocoding.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ResponseException> addressNotFound(AddressNotFoundException e) {
        ResponseException exception = new ResponseException(e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
