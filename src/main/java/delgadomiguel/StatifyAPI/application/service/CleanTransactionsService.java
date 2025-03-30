package delgadomiguel.StatifyAPI.application.service;

import delgadomiguel.StatifyAPI.application.usecase.CleanTransactionsUseCase;
import delgadomiguel.StatifyAPI.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CleanTransactionsService implements CleanTransactionsUseCase {

    private final TransactionRepository repository;

    @Override
    public void execute() {
        log.info("Request arrived at the CleanTransactionsService");
        repository.cleanTransactions();
        log.info("The request has been processed, all transactions have been deleted \n END");
    }
}
