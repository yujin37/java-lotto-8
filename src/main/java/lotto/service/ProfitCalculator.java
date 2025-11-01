package lotto.service;

import java.util.Map;
import lotto.domain.Rank;

public class ProfitCalculator {
    private int calculateTotal(Map<Rank, Integer> winningResult) {
        int totalProfit = 0;
        for(Map.Entry<Rank, Integer> entry: winningResult.entrySet()) {
            int winningAmount = entry.getKey().getMatchAmount();
            int winningCount = entry.getValue();
            totalProfit += winningAmount * winningCount;
        }
        return totalProfit;
    }

    private double calculateRate(int total, int count) {
        double buy = count * 1000.0;
        double rate = ((double) total / buy) * 100;
        return Math.round(rate * 10) / 10.0;
    }

    public double calculateProfitRate(Map<Rank, Integer> winningResult, int count) {
        int total = calculateTotal(winningResult);
        return calculateRate(total, count);
    }
}
