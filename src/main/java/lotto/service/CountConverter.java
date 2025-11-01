package lotto.service;

public class CountConverter {
    private final static int UNIT = 1000;

    public int calculateCount(int money) {
        System.out.println(money);
        return money / UNIT;
    }

    public int convertToCount(String amount) {
        return calculateCount(Integer.parseInt(amount));
    }
}
