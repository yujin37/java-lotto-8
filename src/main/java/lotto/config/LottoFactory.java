package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.CountConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {
    public static LottoController createLottoController() {
        InputView inputView = new InputView();
        CountConverter countConverter = new CountConverter();
        OutputView outputView = new OutputView();
        return new LottoController(inputView, outputView, countConverter);
    }
}
