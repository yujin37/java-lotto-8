package lotto.domain;

public class AmountValidator {
    public static int isNumber(String amount) {
        int money = 0;
        try {
            money = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 구매 금액이 숫자가 아닙니다.");

        }
        return money;
    }
    public static void isUnit(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 구매금액이 1000으로 나누어 떨어지지 않습니다. ");
        }
    }
    public static void isAmount(String amount) {
        int money = isNumber(amount);
        isUnit(money);

    }
}
