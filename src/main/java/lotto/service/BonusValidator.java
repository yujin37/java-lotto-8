package lotto.service;

import java.util.List;
import lotto.exception.NumberErrorMessage;

public class BonusValidator {
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 45;

    private static void duplicateBonus(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(NumberErrorMessage.BONUS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_NUM || bonusNumber > MAX_NUM) {
            throw new IllegalArgumentException(NumberErrorMessage.BONUS_NUMBER_NOT_RANGE.getMessage());
        }
    }

    public static void validateBonus(List<Integer> winningNumber, int bonusNumber) {
        duplicateBonus(winningNumber, bonusNumber);
        validateRange(bonusNumber);
    }
}
