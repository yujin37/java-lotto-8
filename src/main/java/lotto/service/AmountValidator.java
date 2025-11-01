package lotto.service;

import lotto.exception.AmountErrorMessage;
import lotto.exception.LottoConstants;

public class AmountValidator {

    public static int isNumber(String amount) {
        int money = 0;
        try {
            money = Integer.parseInt(amount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_NOT_NUMBER.getMessage());
        }
        return money;
    }

    public static void isUnit(int money) {
        if (money % LottoConstants.UNIT != 0) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_NOT_DIVIDE_UNIT.getMessage());
        }
    }

    public static void isNegative(int money) {
        if (money < LottoConstants.MIN_AMOUNT) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_MIN_MORE.getMessage());
        }
    }

    public static void isMaximum(int money) {
        if (money > LottoConstants.MAX_AMOUNT) {
            throw new IllegalArgumentException(AmountErrorMessage.AMOUNT_MAX_UNDER.getMessage());
        }
    }

    public static void isAmount(String amount) {
        int money = isNumber(amount);
        isNegative(money);
        isMaximum(money);
        isUnit(money);
    }
}
