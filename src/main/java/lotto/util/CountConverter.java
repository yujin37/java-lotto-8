package lotto.util;

import lotto.exception.LottoConstants;

public class CountConverter {

    public static int convertToCount(String amount) {
        return calculateCount(Integer.parseInt(amount.strip()));
    }

    private static int calculateCount(int money) {
        return money / LottoConstants.UNIT;
    }
}
