package delgadomiguel.StatifyAPI.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ExceptionMessage(LocalDateTime timestamp, String message) {
}
