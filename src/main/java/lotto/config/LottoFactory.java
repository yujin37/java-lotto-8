package lotto.config;

import lotto.controller.LottoController;
import lotto.service.CountConverter;
import lotto.service.NumbersConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {
    public InputView inputView() {
        return new InputView();
    }
    public OutputView outputView() {
        return new OutputView();
    }

    public CountConverter countConverter() {
        return new CountConverter();
    }

    public NumbersConverter numbersConverter() {
        return new NumbersConverter();
    }

    public LottoController createLottoController() {
        return new LottoController(
                inputView(),
                outputView(),
                countConverter(),
                numbersConverter()
        );
    }
}
