package delgadomiguel.StatifyAPI.application.usecase;

import delgadomiguel.StatifyAPI.domain.model.Statistics;
import org.springframework.stereotype.Service;

@Service
public interface FindLastTransactionsUseCase {
    public Statistics execute (Long seconds);
}
