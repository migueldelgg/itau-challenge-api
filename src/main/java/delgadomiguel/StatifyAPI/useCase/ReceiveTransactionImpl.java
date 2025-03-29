package delgadomiguel.StatifyAPI.useCase;

import delgadomiguel.StatifyAPI.dto.TransactionReq;
import delgadomiguel.StatifyAPI.entity.Transaction;
import delgadomiguel.StatifyAPI.repository.TransactionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiveTransactionImpl implements ReceiveTransaction{

    @Autowired
    private final TransactionRepository repository;

    public ReceiveTransactionImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(@Valid TransactionReq request) {
        Transaction transaction = Transaction.from(request);
        repository.save(transaction);
    }
}
