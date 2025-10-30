package lotto.controller;


import lotto.domain.AmountValidator;
import lotto.domain.CountConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CountConverter countConverter;

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
    }
}
