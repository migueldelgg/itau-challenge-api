package delgadomiguel.StatifyAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionMessage handleIllegalArgumentException(IllegalArgumentException ex) {
        return ExceptionMessage.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
    }

}
