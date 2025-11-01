package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final WinningDetails winningDetails = new WinningDetails();
    private final ProfitCalculator profitCalculator = new ProfitCalculator();

    public List<List<Integer>> generateTickets(int count) {
        return lottoMachine.issueTicket(count);
    }

    public Map<Rank, Integer> calculateWinning(List<List<Integer>> tickets, List<Integer> winningNumbers,
                                               int bonusNum) {
        return winningDetails.calculateWinning(tickets, winningNumbers, bonusNum);
    }

    public double calculateProfit(Map<Rank, Integer> winningResult, int count) {
        return profitCalculator.calculateProfitRate(winningResult, count);
    }
}
