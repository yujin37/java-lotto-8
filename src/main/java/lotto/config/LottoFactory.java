package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.service.LottoInputService;
import lotto.service.ProfitCalculator;
import lotto.service.WinningDetails;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }


    public LottoInputService lottoInputService() {
        return new LottoInputService(inputView());
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine();
    }

    public WinningDetails winningDetails() {
        return new WinningDetails();
    }

    public ProfitCalculator profitCalculator() {
        return new ProfitCalculator();
    }

    public LottoController createLottoController() {
        return new LottoController(
                lottoInputService(),
                outputView(),
                lottoMachine()
        );
    }
}
