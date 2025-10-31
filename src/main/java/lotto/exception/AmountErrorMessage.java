package lotto.exception;

public enum AmountErrorMessage {
    AMOUNT_NOT_NUMBER("[Error] 구매 금액이 숫자가 아닙니다."),
    AMOUNT_NOT_DIVIDE_UNIT("[Error] 구매금액이 1000으로 나누어 떨어지지 않습니다."),
    AMOUNT_MIN_MORE("[Error] 구매금액은 1000원 이상이어야 합니다."),
    AMOUNT_MAX_UNDER("[Error] 로또를 한번에 살 수 있는 구매 금액은 최대 10만원 입니다.");

    private final String message;

    AmountErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
