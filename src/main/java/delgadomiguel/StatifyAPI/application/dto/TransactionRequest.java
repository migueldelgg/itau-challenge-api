package delgadomiguel.StatifyAPI.application.dto;

import java.math.BigDecimal;

public record TransactionRequest
        (
                BigDecimal valor, String dataHora
        ) {
}
