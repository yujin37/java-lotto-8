package lotto.service;

import java.util.Map;
import lotto.domain.Rank;

public class ProfitCalculator {
    private final static double LOTTO_PRICE = 1000.0;
    private final static int RATE_MULTI = 100;
    private final static int ROUND_MULTI = 10;
    private final static double ROUND_DIVIDE = (double) ROUND_MULTI;

    private int calculateTotal(Map<Rank, Integer> winningResult) {
        int totalProfit = 0;
        for (Map.Entry<Rank, Integer> entry : winningResult.entrySet()) {
            int winningAmount = entry.getKey().getMatchAmount();
            int winningCount = entry.getValue();
            totalProfit += winningAmount * winningCount;
        }
        return totalProfit;
    }

    private double calculateRate(int total, int count) {
        double buy = count * LOTTO_PRICE;
        double rate = ((double) total / buy) * RATE_MULTI;
        return Math.round(rate * ROUND_MULTI) / ROUND_DIVIDE;
    }

    public double calculateProfitRate(Map<Rank, Integer> winningResult, int count) {
        int total = calculateTotal(winningResult);
        return calculateRate(total, count);
    }
}
