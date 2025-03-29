package delgadomiguel.StatifyAPI.infrastructure.controller;

import delgadomiguel.StatifyAPI.application.usecase.CleanTransactionsUseCase;
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

    @Autowired
    private final CleanTransactionsUseCase cleanTransactions;

    public TransactionController(ReceiveTransactionUseCase receiveTransaction, CleanTransactionsUseCase cleanTransactions) {
        this.receiveTransaction = receiveTransaction;
        this.cleanTransactions = cleanTransactions;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> receiveTransaction(@RequestBody TransactionRequest req) {
        receiveTransaction.execute(req);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> cleanTransactions() {
        cleanTransactions.execute();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
