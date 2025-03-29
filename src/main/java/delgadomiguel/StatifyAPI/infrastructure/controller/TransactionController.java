package delgadomiguel.StatifyAPI.http;

import delgadomiguel.StatifyAPI.application.usecase.FindLastTransactionsUseCase;
import delgadomiguel.StatifyAPI.domain.model.Statistics;
import delgadomiguel.StatifyAPI.dto.TransactionReq;
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
    private final FindLastTransactionsUseCase findLastTransactions;

    public TransactionController(ReceiveTransactionUseCase receiveTransaction, FindLastTransactionsUseCase findLastTransactions) {
        this.receiveTransaction = receiveTransaction;
        this.findLastTransactions = findLastTransactions;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> receiveTransaction(@RequestBody TransactionReq req) {
        receiveTransaction.execute(req);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Statistics> getStats(@RequestParam(name = "seconds", required = false, defaultValue = "60") Long seconds) {
        var response = findLastTransactions.execute(seconds);

        // Teste de saída para debug
        System.out.println("Stats Response: " + response.toString());

        return ResponseEntity.ok(response);
    }

}
