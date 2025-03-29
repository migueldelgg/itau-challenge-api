package delgadomiguel.StatifyAPI.application.usecase;

import delgadomiguel.StatifyAPI.dto.TransactionReq;

public interface ReceiveTransaction {

    public void execute (TransactionReq req);

}
