package delgadomiguel.StatifyAPI.domain.model;

import delgadomiguel.StatifyAPI.application.dto.TransactionRequest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Transaction {

    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public Transaction(BigDecimal valor, String dataHora) {
        validateOffsetDateTimeValue(dataHora);
        OffsetDateTime parsedDateTime = parseDateTime(dataHora);
        validateValue(valor);
        validateDateTime(parsedDateTime);
        this.dataHora = parsedDateTime;
        this.valor = valor;
    }

    public static Transaction from(TransactionRequest transactionReq) {
        return new Transaction(transactionReq.valor(), transactionReq.dataHora());
    }

    private void validateValue(BigDecimal input) {
        if (input == null || input.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
    }

    private OffsetDateTime parseDateTime(String input) {
        try {
            return OffsetDateTime.parse(input, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDateTime(OffsetDateTime dateTime) {
        OffsetDateTime minDate = OffsetDateTime.parse("1998-01-01T00:00:00Z");

        if (dateTime.isAfter(OffsetDateTime.now()) || dateTime.isBefore(minDate)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOffsetDateTimeValue(String dataHora) {
        if (dataHora == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "valor=" + valor +
                ", dataHora=" + dataHora +
                '}';
    }

    public BigDecimal getValor() {
        return valor;
    }
}
