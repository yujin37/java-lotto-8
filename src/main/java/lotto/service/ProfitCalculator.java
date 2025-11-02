package lotto.service;

import java.util.Map;
import lotto.domain.Rank;
import lotto.exception.LottoConstants;

public class ProfitCalculator {

    public double calculateProfitRate(Map<Rank, Integer> winningResult, int count) {
        int total = calculateTotal(winningResult);
        return calculateRate(total, count);
    }

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
        double buy = count * LottoConstants.LOTTO_PRICE;
        double rate = ((double) total / buy) * LottoConstants.RATE_MULTI;
        return Math.round(rate * LottoConstants.ROUND_MULTI) / LottoConstants.ROUND_DIVIDE;
    }
}
