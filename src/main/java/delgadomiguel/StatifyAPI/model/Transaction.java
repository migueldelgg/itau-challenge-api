package delgadomiguel.StatifyAPI.model;

import delgadomiguel.StatifyAPI.dto.TransactionReq;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Transaction {

    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public Transaction(BigDecimal valor, String dataHora) {
        OffsetDateTime parsedDateTime = parseDateTime(dataHora);
        validateValue(valor);
        validateDateTime(parsedDateTime);
        this.dataHora = parsedDateTime;
        this.valor = valor;
    }

    public static Transaction from(TransactionReq transactionReq) {
        return new Transaction(transactionReq.valor(), transactionReq.dataHora());
    }

    private void validateValue(BigDecimal input) {
        if (input == null || input.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor da transação não pode ser negativo ou nulo.");
        }
    }

    private OffsetDateTime parseDateTime(String input) {
        try {
            return OffsetDateTime.parse(input, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido.");
        }
    }

    private void validateDateTime(OffsetDateTime dateTime) {
        if (dateTime.isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("A data informada não pode ser do futuro.");
        }
    }
}
