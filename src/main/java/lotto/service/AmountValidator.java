package lotto.service;

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

    public static void isNegative(int money) {
        if(money < 1000) {
            throw new IllegalArgumentException("[Error] 구매금액은 1000원 이상이어야 합니다.");
        }
    }

    public static void isMaximum(int money) {
        if(money > 100000) {
            throw new IllegalArgumentException("[Error] 로또를 한번에 살 수 있는 구매 금액은 최대 10만원 입니다.");
        }
    }

    public static void isAmount(String amount) {
        int money = isNumber(amount);
        isUnit(money);
        isNegative(money);
        isMaximum(money);
    }
}
