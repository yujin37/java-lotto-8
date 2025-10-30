package lotto;

import lotto.config.LottoFactory;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoFactory.createLottoController();
        lottoController.run();
    }
}
