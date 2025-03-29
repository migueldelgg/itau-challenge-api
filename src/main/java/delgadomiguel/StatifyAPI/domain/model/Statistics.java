package delgadomiguel.StatifyAPI.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Getter
public class Statistics {

    private Integer count;
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal min;
    private BigDecimal max;

    public Statistics(BigDecimal avg, Integer count, BigDecimal max, BigDecimal min, BigDecimal sum) {
        this.avg = avg;
        this.count = count;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }

    public static Statistics execute(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            return new Statistics(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }

        DoubleSummaryStatistics stats = transactions.stream()
                .map(Transaction::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();

        BigDecimal sum = BigDecimal.valueOf(stats.getSum()).max(BigDecimal.ZERO);
        BigDecimal min = BigDecimal.valueOf(stats.getMin()).max(BigDecimal.ZERO);
        BigDecimal max = BigDecimal.valueOf(stats.getMax()).max(BigDecimal.ZERO);
        BigDecimal avg = BigDecimal.valueOf(stats.getAverage()).max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
        int count = transactions.size();

        return new Statistics(avg, count, max, min, sum);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "avg=" + avg +
                ", count=" + count +
                ", sum=" + sum +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
