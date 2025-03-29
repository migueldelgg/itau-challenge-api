package delgadomiguel.StatifyAPI.http;

import delgadomiguel.StatifyAPI.dto.TransactionReq;
import delgadomiguel.StatifyAPI.useCase.ReceiveTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private final ReceiveTransaction receiveTransaction;

    public TransactionController(ReceiveTransaction receiveTransaction) {
        this.receiveTransaction = receiveTransaction;
    }

    @PostMapping("/transacao")
    @ResponseBody
    public ResponseEntity<Void> receiveTransaction(@RequestBody TransactionReq req) {
        receiveTransaction.execute(req);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
