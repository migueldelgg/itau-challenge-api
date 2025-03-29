package delgadomiguel.StatifyAPI.infrastructure.controller;

import delgadomiguel.StatifyAPI.application.usecase.FindLastTransactionsUseCase;
import delgadomiguel.StatifyAPI.domain.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    @Autowired
    private final FindLastTransactionsUseCase findLastTransactions;

    public StatisticsController(FindLastTransactionsUseCase findLastTransactions) {
        this.findLastTransactions = findLastTransactions;
    }
    
    @GetMapping("/estatistica")
    public ResponseEntity<Statistics> getStats(@RequestParam(name = "seconds", required = false, defaultValue = "60") Long seconds) {
        var response = findLastTransactions.execute(seconds);
        System.out.println("Stats Response: " + response.toString());
        return ResponseEntity.ok(response);
    }
}
