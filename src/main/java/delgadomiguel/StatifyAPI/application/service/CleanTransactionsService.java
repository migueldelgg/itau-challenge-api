package delgadomiguel.StatifyAPI.application.service;

import delgadomiguel.StatifyAPI.application.usecase.CleanTransactionsUseCase;
import delgadomiguel.StatifyAPI.infrastructure.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleanTransactionsService implements CleanTransactionsUseCase {

    @Autowired
    private final TransactionRepository repository;

    public CleanTransactionsService(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.cleanTransactions();
    }
}
