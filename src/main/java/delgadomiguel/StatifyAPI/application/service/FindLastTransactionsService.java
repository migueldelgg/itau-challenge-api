package delgadomiguel.StatifyAPI.application.service;

import delgadomiguel.StatifyAPI.domain.model.Statistics;
import delgadomiguel.StatifyAPI.infrastructure.repository.TransactionRepository;
import delgadomiguel.StatifyAPI.application.usecase.FindLastTransactionsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindLastTransactionsService implements FindLastTransactionsUseCase {

    private final TransactionRepository repository;

    @Override
    public Statistics execute(Long seconds) {
        log.info("Request arrived at the FindLastTransactionsService");
        var filterTransactions = repository.findBySeconds(seconds);
        log.info("Request was processed, result: \n{}\n END", filterTransactions.toString());
        return Statistics.execute(filterTransactions);
    }
}
