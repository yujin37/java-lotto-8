package lotto.controller;


import java.util.List;
import lotto.config.LottoFactory;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.service.AmountValidator;
import lotto.service.CountConverter;
import lotto.domain.GenerateNumbers;
import lotto.service.NumbersConverter;
import lotto.service.NumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CountConverter countConverter;
    private final NumbersConverter numbersConverter;

    private final LottoMachine lottoMachine = new LottoMachine();

    public LottoController(InputView inputView, OutputView outputView, CountConverter countConverter, NumbersConverter numbersConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.countConverter = countConverter;
        this.numbersConverter = numbersConverter;
    }

    public int checkAmount() {
        while (true) {
            try {
                String purChaseAmount = inputView.inputPurchaseAmount();
                AmountValidator.isAmount(purChaseAmount);
                return countConverter.convertToCount(purChaseAmount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> checkNumbers() {
        while (true) {
            try {
                String winningNumber = inputView.inputWinningNumbers();
                //로또를 먼저 검증
                NumbersValidator.isNumbers(winningNumber);
                //로또 변환
                return numbersConverter.convertToNumbers(winningNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void run() {
        int count = checkAmount();
        outputView.outputPurchaseCount(count);
        List<List<Integer>> tickets = lottoMachine.issueTicket(count);
        outputView.outputTickets(tickets);
        List<Integer> winningNumbers = checkNumbers();
        Lotto lotto = new Lotto(winningNumbers);
    }
}
