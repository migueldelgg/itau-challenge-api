package delgadomiguel.StatifyAPI.domain.model.transaction;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/*
* Encapsulando o comportamento da dataHora.
*
* */
public class DataHora {

    private OffsetDateTime dataHora;

    public DataHora(String dataHora) {
        isNull(dataHora);
        OffsetDateTime parsedDateTime = parseInput(dataHora);
        offSetDateTimeIsValid(parsedDateTime);
        this.dataHora = parsedDateTime;
    }

    public static DataHora create(String dataHora) {
        return new DataHora(dataHora);
    }

    private OffsetDateTime parseInput(String input) {
        try {
            return OffsetDateTime.parse(input, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException();
        }
    }

    private void offSetDateTimeIsValid(OffsetDateTime dateTime) {
        OffsetDateTime minDate = OffsetDateTime.parse("1998-01-01T00:00:00Z");

        if (dateTime.isAfter(OffsetDateTime.now()) || dateTime.isBefore(minDate)) {
            throw new IllegalArgumentException();
        }
    }

    private void isNull(String dataHora) {
        if (dataHora == null) {
            throw new IllegalArgumentException();
        }
    }

    public OffsetDateTime getValue() {
        return dataHora;
    }
}
