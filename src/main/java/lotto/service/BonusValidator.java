package lotto.service;

import java.util.List;
import lotto.exception.NumberErrorMessage;

public class BonusValidator {
    private static void duplicateBonus(List<Integer> winningNumber, int bonusNumber) {
        if(winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(NumberErrorMessage.BONUS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateRange(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(NumberErrorMessage.BONUS_NUMBER_NOT_RANGE.getMessage());
        }
    }
    public static void validateBonus(List<Integer> winningNumber, int bonusNumber) {
        duplicateBonus(winningNumber, bonusNumber);
        validateRange(bonusNumber);
    }
}
