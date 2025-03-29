package delgadomiguel.StatifyAPI.application.usecase;

import delgadomiguel.StatifyAPI.application.dto.TransactionRequest;

public interface ReceiveTransactionUseCase {
    public void execute (TransactionRequest req);
}
