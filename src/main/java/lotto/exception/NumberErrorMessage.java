package lotto.exception;

public enum NumberErrorMessage {
    WINNING_NUMBERS_EMPTY("[ERROR] 당첨 번호가 비어있습니다."),
    WINNING_NUMBERS_NOT_NUMBER("[ERROR] 당첨 번호가 숫자가 아닙니다."),
    BONUS_NUMBER_NOT_NUMBER("[ERROR] 보너스 번호가 숫자가 아닙니다."),
    BONUS_NUMBER_EMPTY("[ERROR] 보너스 번호가 비어있습니다."),
    BONUS_DUPLICATE_WINNING_NUMBER("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다."),
    BONUS_NUMBER_NOT_RANGE("[ERROR] 보너스 번호가 범위에 속하지 않습니다. 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
    private final String message;

    NumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
