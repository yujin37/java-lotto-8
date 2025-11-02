package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.NumberErrorMessage;
import lotto.util.BonusValidator;
import lotto.util.NumbersConverter;
import lotto.util.NumbersValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {
    //보너스 번호가 문자인 경우
    @ParameterizedTest
    @ValueSource(strings = {"!", "aa"})
    void 보너스_번호가_문자인_경우(String bonus) {
        NumbersConverter numbersConverter = new NumbersConverter();
        assertThatThrownBy(() -> numbersConverter.convertToBonus(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.BONUS_NUMBER_NOT_NUMBER.getMessage());
    }

    //보너스 번호가 빈 문자열 들어올 경우
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 보너스_번호가_빈_문자열인_경우(String bonus) {
        assertThatThrownBy(() -> NumbersValidator.isBonus(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.BONUS_NUMBER_EMPTY.getMessage());
    }

    //보너스 번호가 당첨 번호랑 겹치는 경우
    @Test
    void 보너스_번호가_당첨_번호랑_겹치는_경우() {
        int bonus = 13;
        List<Integer> winningNumber = List.of(2, 13, 5, 42, 28, 45);
        assertThatThrownBy(() -> BonusValidator.validateBonus(winningNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.BONUS_DUPLICATE_WINNING_NUMBER.getMessage());
    }

    //보너스 번호가 범위를 초과할 경우
    @Test
    void 보너스_번호가_범위를_넘어가는_경우() {
        int bonus = 57;
        List<Integer> winningNumber = List.of(2, 13, 5, 42, 28, 45);
        assertThatThrownBy(() -> BonusValidator.validateBonus(winningNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.BONUS_NUMBER_NOT_RANGE.getMessage());
    }

    // 보너스 번호 정상 입력
    @Test
    void 보너스_번호_정상_입력() {
        int bonus = 28;
        List<Integer> winningNumber = List.of(2, 13, 5, 42, 27, 45);
        assertThatCode(() -> BonusValidator.validateBonus(winningNumber, bonus)).doesNotThrowAnyException();
    }
}
