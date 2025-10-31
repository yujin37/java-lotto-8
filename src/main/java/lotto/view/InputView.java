package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_MESSAGE);
        return Console.readLine();
    }
}
