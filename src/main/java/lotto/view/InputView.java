package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoMessage;

public class InputView {

    private static String readConsole(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static String inputPurchaseAmount() {
        return readConsole(LottoMessage.PURCHASE_MESSAGE);
    }

    public static String inputWinningNumbers() {
        return readConsole(LottoMessage.WINNING_MESSAGE);
    }

    public static String inputBonusNumber() {
        return readConsole(LottoMessage.BONUS_MESSAGE);
    }
}
