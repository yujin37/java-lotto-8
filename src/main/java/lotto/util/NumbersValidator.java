package lotto.util;

import static lotto.exception.NumberErrorMessage.WINNING_NUMBERS_EMPTY;

import lotto.exception.NumberErrorMessage;

public class NumbersValidator {

    public static void isNumbers(String numbers) {
        isEmpty(numbers.strip(), WINNING_NUMBERS_EMPTY.getMessage());
    }

    public static void isBonus(String bonus) {
        isEmpty(bonus.strip(), NumberErrorMessage.BONUS_NUMBER_EMPTY.getMessage());
    }

    private static void isEmpty(String numbers, String errorMessage) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
