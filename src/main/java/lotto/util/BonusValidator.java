package lotto.util;

import java.util.List;
import lotto.exception.LottoConstants;
import lotto.exception.NumberErrorMessage;

public class BonusValidator {

    private BonusValidator() {
    }

    public static void validateBonus(List<Integer> winningNumber, int bonusNumber) {
        duplicateBonus(winningNumber, bonusNumber);
        validateRange(bonusNumber);
    }

    private static void duplicateBonus(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(NumberErrorMessage.BONUS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < LottoConstants.MIN_NUM || bonusNumber > LottoConstants.MAX_NUM) {
            throw new IllegalArgumentException(NumberErrorMessage.BONUS_NUMBER_NOT_RANGE.getMessage());
        }
    }
}
