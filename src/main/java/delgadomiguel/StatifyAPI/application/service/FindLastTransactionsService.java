package delgadomiguel.StatifyAPI.application.service;

import delgadomiguel.StatifyAPI.domain.model.Statistics;
import delgadomiguel.StatifyAPI.infrastructure.repository.TransactionRepository;
import delgadomiguel.StatifyAPI.application.usecase.FindLastTransactionsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindLastTransactionsService implements FindLastTransactionsUseCase {

    @Autowired
    private final TransactionRepository repository;

    public FindLastTransactionsService(TransactionRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Statistics execute(Long seconds) {
        var filterTransactions = repository.findBySeconds(seconds);
        return Statistics.execute(filterTransactions);
    }
}
