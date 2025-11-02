package lotto.service;

import lotto.exception.LottoConstants;

public class CountConverter {

    public int convertToCount(String amount) {
        return calculateCount(Integer.parseInt(amount.strip()));
    }

    private int calculateCount(int money) {
        return money / LottoConstants.UNIT;
    }
}
