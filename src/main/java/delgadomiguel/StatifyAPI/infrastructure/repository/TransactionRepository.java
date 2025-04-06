package delgadomiguel.StatifyAPI.infrastructure.repository;

import delgadomiguel.StatifyAPI.domain.model.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository {

    public void save(Transaction transaction);

    public List<Transaction> findBySeconds (Long seconds);

    public void cleanTransactions();
}
