package lotto.service;

import static lotto.exception.NumberErrorMessage.WINNING_NUMBERS_EMPTY;

import lotto.exception.NumberErrorMessage;

public class NumbersValidator {

    public static void isNumbers(String numbers) {
        isEmpty(numbers, WINNING_NUMBERS_EMPTY.getMessage());
    }

    public static void isBonus(String bonus) {
        isEmpty(bonus, NumberErrorMessage.BONUS_NUMBER_EMPTY.getMessage());
    }

    private static void isEmpty(String numbers, String errorMessage) {
        if (numbers.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
