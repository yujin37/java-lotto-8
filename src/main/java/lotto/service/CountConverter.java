package lotto.service;

import lotto.exception.LottoConstants;

public class CountConverter {

    public int calculateCount(int money) {
        System.out.println(money);
        return money / LottoConstants.UNIT;
    }

    public int convertToCount(String amount) {
        return calculateCount(Integer.parseInt(amount));
    }
}
