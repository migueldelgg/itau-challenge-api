package delgadomiguel.StatifyAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionReq
        (
                BigDecimal valor, String dataHora
        ) {
}
