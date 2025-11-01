package lotto.service;

import lotto.exception.AmountErrorMessage;
import lotto.exception.LottoConstants;

public class AmountValidator {

    public static void isAmount(String amount) {
        int money = isNumber(amount);
        isNegative(money);
        isMaximum(money);
        isUnit(money);
    }

    private static int isNumber(String amount) {
        int money = 0;
        try {
            money = Integer.parseInt(amount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_NOT_NUMBER.getMessage());
        }
        return money;
    }

    private static void isUnit(int money) {
        if (money % LottoConstants.UNIT != 0) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_NOT_DIVIDE_UNIT.getMessage());
        }
    }

    private static void isNegative(int money) {
        if (money < LottoConstants.MIN_AMOUNT) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_MIN_MORE.getMessage());
        }
    }

    private static void isMaximum(int money) {
        if (money > LottoConstants.MAX_AMOUNT) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_MAX_UNDER.getMessage());
        }
    }
}
