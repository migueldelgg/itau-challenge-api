package delgadomiguel.StatifyAPI.useCase;

import delgadomiguel.StatifyAPI.dto.TransactionReq;

public interface ReceiveTransaction {

    public void execute (TransactionReq req);

}
