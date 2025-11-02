package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.NumberErrorMessage;
import lotto.util.NumbersConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {

    NumbersConverter numbersConverter = new NumbersConverter();

    @Test
    void 당첨번호_정상_입력() {
        String winningNumbers = "1,2,3";
        assertThatCode(() -> numbersConverter.convertToNumbers(winningNumbers))
                .doesNotThrowAnyException();

    }

    @ParameterizedTest
    @ValueSource(strings = {" 1,2,3", "1, 2,3", "1,2,3 ", "1, 2, 3"})
    void 당첨번호_여러가지_공백_포함_입력(String winningNumbers) {
        assertThatCode(() -> numbersConverter.convertToNumbers(winningNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2, ", " ", "", "1,2,!"})
    void 당첨번호가_제대로_입력되지_않는_경우(String winningNumbers) {
        assertThatThrownBy(() -> numbersConverter.convertToNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.WINNING_NUMBERS_NOT_NUMBER.getMessage());
    }
}
