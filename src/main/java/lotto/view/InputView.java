package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoMessage;

public class InputView {

    public static String inputPurchaseAmount() {
        System.out.println(LottoMessage.PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(LottoMessage.WINNING_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(LottoMessage.BONUS_MESSAGE);
        return Console.readLine();
    }
}
