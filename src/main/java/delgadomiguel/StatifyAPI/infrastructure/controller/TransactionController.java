package delgadomiguel.StatifyAPI.infrastructure.controller;

import delgadomiguel.StatifyAPI.domain.model.Statistics;
import delgadomiguel.StatifyAPI.application.dto.TransactionRequest;
import delgadomiguel.StatifyAPI.application.usecase.ReceiveTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private final ReceiveTransactionUseCase receiveTransaction;

    public TransactionController(ReceiveTransactionUseCase receiveTransaction) {
        this.receiveTransaction = receiveTransaction;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> receiveTransaction(@RequestBody TransactionRequest req) {
        receiveTransaction.execute(req);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
