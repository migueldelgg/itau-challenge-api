package delgadomiguel.StatifyAPI.repository;

import delgadomiguel.StatifyAPI.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTransactionRepository implements TransactionRepository{

    private final Map<Long, Transaction> transactions = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(Transaction transaction) {
        long transactionId = idGenerator.getAndIncrement();
        transactions.put(transactionId, transaction);

        System.out.println("Transactions: \n" + transactions.values());
    }

}
