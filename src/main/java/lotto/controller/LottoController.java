package lotto.controller;


import java.util.List;
import java.util.Map;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.service.LottoInputService;
import lotto.service.ProfitCalculator;
import lotto.service.WinningDetails;
import lotto.view.OutputView;

public class LottoController {
    private final LottoInputService lottoInputService;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;


    public void run() {
        int count = purchaseAmount();
        List<List<Integer>> tickets = issueLottoNumbers(count);
        Map<Rank, Integer> winningResult = processWinning(tickets);
        processProfitRate(winningResult, count);
    }

    public LottoController(LottoInputService lottoInputService, OutputView outputView, LottoMachine lottoMachine) {
        this.lottoInputService = lottoInputService;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    private int purchaseAmount() {
        int count = lottoInputService.checkAmount();
        outputView.outputPurchaseCount(count);
        return count;
    }

    private List<List<Integer>> issueLottoNumbers(int count) {
        List<List<Integer>> tickets = lottoMachine.issueTicket(count);
        outputView.outputTickets(tickets);
        return tickets;
    }

    private Map<Rank, Integer> processWinning(List<List<Integer>> tickets) {
        List<Integer> winningNumbers = lottoInputService.checkNumbers();
        int bonusNum = lottoInputService.checkBonus(winningNumbers);

        WinningDetails winningDetails = new WinningDetails();
        Map<Rank, Integer> winningResult = winningDetails.calculateWinning(tickets, winningNumbers, bonusNum);
        outputView.outputStatistics(winningResult);
        return winningResult;
    }

    private void processProfitRate(Map<Rank, Integer> winningResult, int count) {
        ProfitCalculator calculator = new ProfitCalculator();
        double profit = calculator.calculateProfitRate(winningResult, count);
        outputView.outputProfitRate(profit);
    }

}
