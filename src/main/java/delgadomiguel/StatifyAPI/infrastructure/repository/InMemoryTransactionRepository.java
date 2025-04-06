package delgadomiguel.StatifyAPI.infrastructure.repository;

import delgadomiguel.StatifyAPI.domain.model.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryTransactionRepository implements TransactionRepository{

    private final Map<OffsetDateTime, Transaction> transactions = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(Transaction transaction) {
        transactions.put(OffsetDateTime.now(), transaction);
        System.out.println("Transactions: \n" + transactions.values());
    }

    @Override
    public List<Transaction> findBySeconds(Long seconds) {
        OffsetDateTime desiredTime = OffsetDateTime.now().minusSeconds(seconds);

        return transactions.entrySet().stream()
                .filter(entry -> entry.getKey().isAfter(desiredTime))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void cleanTransactions() {
        transactions.clear();
    }

}
