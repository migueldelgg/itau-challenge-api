package delgadomiguel.StatifyAPI.application.service;

import delgadomiguel.StatifyAPI.application.usecase.ReceiveTransactionUseCase;
import delgadomiguel.StatifyAPI.application.dto.TransactionRequest;
import delgadomiguel.StatifyAPI.domain.model.Transaction;
import delgadomiguel.StatifyAPI.infrastructure.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiveTransactionService implements ReceiveTransactionUseCase {

    @Autowired
    private final TransactionRepository repository;

    public ReceiveTransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(TransactionRequest request) {
        Transaction transaction = Transaction.from(request);
        repository.save(transaction);
    }
}
