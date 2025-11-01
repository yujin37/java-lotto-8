package lotto.controller;


import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.AmountValidator;
import lotto.service.BonusValidator;
import lotto.service.CountConverter;
import lotto.service.LottoService;
import lotto.service.NumbersConverter;
import lotto.service.NumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CountConverter countConverter;
    private final NumbersConverter numbersConverter;

    private final LottoService lottoService = new LottoService();

    public void run() {
        int count = checkAmount();
        outputView.outputPurchaseCount(count);
        List<List<Integer>> tickets = lottoService.generateTickets(count);
        outputView.outputTickets(tickets);
        List<Integer> winningNumbers = checkNumbers();
        int bonusNum = checkBonus(winningNumbers);
        Map<Rank, Integer> winningResult = lottoService.calculateWinning(tickets, winningNumbers, bonusNum);
        outputView.outputStatistics(winningResult);
        double profit = lottoService.calculateProfit(winningResult, count);
        outputView.outputProfitRate(profit);
    }
    
    public LottoController(InputView inputView, OutputView outputView, CountConverter countConverter,
                           NumbersConverter numbersConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.countConverter = countConverter;
        this.numbersConverter = numbersConverter;
    }

    private int checkAmount() {
        while (true) {
            try {
                String purChaseAmount = inputView.inputPurchaseAmount();
                AmountValidator.isAmount(purChaseAmount);
                return countConverter.convertToCount(purChaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                throw e;
            }
        }
    }

    private List<Integer> checkNumbers() {
        while (true) {
            try {
                String winningNumber = inputView.inputWinningNumbers();
                //로또를 먼저 검증
                NumbersValidator.isNumbers(winningNumber);
                //로또 변환
                List<Integer> winningNumbers = numbersConverter.convertToNumbers(winningNumber);
                new Lotto(winningNumbers);
                return winningNumbers;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int checkBonus(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                //검증 자체는 동일
                NumbersValidator.isNumbers(bonusNumber);
                int bonus = numbersConverter.convertToBonus(bonusNumber);
                BonusValidator.validateBonus(winningNumbers, bonus);
                return bonus;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
