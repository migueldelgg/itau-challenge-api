package delgadomiguel.StatifyAPI.application.service;

import delgadomiguel.StatifyAPI.application.usecase.ReceiveTransactionUseCase;
import delgadomiguel.StatifyAPI.application.dto.TransactionRequest;
import delgadomiguel.StatifyAPI.domain.model.transaction.Transaction;
import delgadomiguel.StatifyAPI.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiveTransactionService implements ReceiveTransactionUseCase {

    private final TransactionRepository repository;

    @Override
    public void execute(TransactionRequest request) {
        log.info("Request arrived at the ReceiveTransactionService");
        Transaction transaction = Transaction.from(request);
        repository.save(transaction);
        log.info("Request was processed, result: \n{}\n END", transaction);
    }
}
