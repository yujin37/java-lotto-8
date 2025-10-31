package lotto.service;

import java.util.List;
import lotto.exception.NumberErrorMessage;

public class BonusValidator {
    public static void validateBonus(List<Integer> winningNumber, int bonusNumber) {
        if(winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(NumberErrorMessage.BONUS_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
