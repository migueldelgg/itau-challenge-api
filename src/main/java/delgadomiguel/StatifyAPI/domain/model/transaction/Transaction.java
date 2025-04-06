package delgadomiguel.StatifyAPI.domain.model.transaction;

import delgadomiguel.StatifyAPI.application.dto.TransactionRequest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transaction {

    private final Valor valor;
    private final DataHora dataHora;

    public Transaction(BigDecimal valorInput, String dataHoraInput) {
        DataHora finalDataHora = DataHora.create(dataHoraInput);
        Valor finalValor = Valor.create(valorInput);
        this.dataHora = finalDataHora;
        this.valor = finalValor;
    }

    public static Transaction from(TransactionRequest transactionReq) {
        return new Transaction(transactionReq.valor(), transactionReq.dataHora());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "valor=" + valor +
                ", dataHora=" + dataHora +
                '}';
    }

    public OffsetDateTime getDataHora() {
        return dataHora.getValue();
    }

    public BigDecimal getValor() {
        return valor.getValue();
    }
}
