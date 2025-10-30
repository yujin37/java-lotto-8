package lotto.domain;

public class CountConverter {
    public int calculateCount(int money) {
        System.out.println(money);
        return money / 1000;
    }
    public int convertToCount(String amount){
        return calculateCount(Integer.parseInt(amount));
    }
}
