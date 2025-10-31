package lotto.service;

import static lotto.exception.NumberErrorMessage.WINNING_NUMBERS_EMPTY;

public class NumbersValidator {
    private static void isEmpty(String numbers) {
        if(numbers.trim().isEmpty()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_EMPTY.getMessage());
        }
    }
    public static void isNumbers(String numbers) {
        isEmpty(numbers);
    }
}
