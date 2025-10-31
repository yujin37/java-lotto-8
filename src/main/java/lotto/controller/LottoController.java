package lotto.controller;


import java.util.List;
import lotto.config.LottoFactory;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.service.AmountValidator;
import lotto.service.CountConverter;
import lotto.domain.GenerateNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CountConverter countConverter;

    private final LottoMachine lottoMachine = new LottoMachine();

    public LottoController(InputView inputView, OutputView outputView, CountConverter countConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.countConverter = countConverter;
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
    public void run() {
        int count = checkAmount();
        outputView.outputPurchaseCount(count);
        List<Lotto> tickets = lottoMachine.issueTicket(count);
        outputView.outputTickets(tickets);
    }
}
