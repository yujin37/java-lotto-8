package lotto.domain;

public enum Rank {
    LOSE(0, "", 0),
    FIFTH(3, "개 일치", 5000),
    FOURTH(4, "개 일치", 50000),
    THIRD(5, "개 일치", 1500000),
    SECOND(5, "개 일치, 보너스 볼 일치", 30000000),
    FIRST(6,"개 일치", 2000000000);

    private final int matchNumbers;
    private final String message;
    private final int matchAmount;

    Rank(int matchNumbers, String message, int matchAmount) {
        this.matchNumbers = matchNumbers;
        this.message = message;
        this.matchAmount = matchAmount;

    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public String getMessage() {
        return message;
    }
    public int getMatchAmount() {
        return matchAmount;
    }

}
