package lotto;

import lotto.config.LottoFactory;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        LottoController lottoController = lottoFactory.createLottoController();
        lottoController.run();
    }
}
