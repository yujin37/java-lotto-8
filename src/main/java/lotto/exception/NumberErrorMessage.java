package lotto.exception;

public enum NumberErrorMessage {
    WINNING_NUMBERS_EMPTY("[ERROR] 당첨 번호가 비어있습니다."),
    WINNING_NUMBERS_NOT_NUMBER("[ERROR] 당첨 번호가 숫자가 아닙니다.");


    private final String message;

    NumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
