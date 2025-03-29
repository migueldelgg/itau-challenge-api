package delgadomiguel.StatifyAPI.repository;

import delgadomiguel.StatifyAPI.entity.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository {

    public void save(Transaction transaction);
}
