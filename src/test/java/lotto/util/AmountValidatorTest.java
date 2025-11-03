package lotto.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.AmountErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountValidatorTest {
    //에러 메시지
    //1. 너무 큰 입력
    @Test
    void 구매금액이_매우_큰_경우() {
        String amount = "101000"; // 10만 1000원
        assertThatThrownBy(() -> AmountValidator.isAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AmountErrorMessage.AMOUNT_MAX_UNDER.getMessage());
    }

    //2. 작은 입력
    @ParameterizedTest
    @ValueSource(strings = {"-2000", "0", "500"})
    void 구매금액이_너무_작은_경우(String amount) {
        //음수, 0, 1000원미만 동시 테스트
        assertThatThrownBy(() -> AmountValidator.isAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AmountErrorMessage.AMOUNT_MIN_MORE.getMessage());
    }

    //3. 문자 입력(특수문자, 알파벳, 한글)
    @ParameterizedTest
    @ValueSource(strings = {"!!!!", "abc", "2000won", "2000.5"})
    void 구매금액이_문자로_들어온_경우(String amount) {
        assertThatThrownBy(() -> AmountValidator.isAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AmountErrorMessage.AMOUNT_NOT_NUMBER.getMessage());
    }

    //4. 빈 입력("", " ")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 구매금액이_비어있는_경우(String amount) {
        //"", " " 테스트
        assertThatThrownBy(() -> AmountValidator.isAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AmountErrorMessage.AMOUNT_NOT_NUMBER.getMessage());
    }

    //5. 나누어 떨어지지 않는
    @Test
    void 구매금액이_나누어_떨어지지_않는_경우() {
        String amount = "4500";
        assertThatThrownBy(() -> AmountValidator.isAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AmountErrorMessage.AMOUNT_NOT_DIVIDE_UNIT.getMessage());
    }

    //에러 없는
    //1. 앞뒤 공백있으나 정상 입력
    @ParameterizedTest
    @ValueSource(strings = {" 2000", "5000 ", " 10000 "})
    void 앞뒤_공백있으나_정상_입력(String amount) {
        assertThatCode(() -> AmountValidator.isAmount(amount)).doesNotThrowAnyException();
    }

    //2. 나누어 떨어지는 숫자(1000원 단위)
    void 나누어_떨어지는_정상_입력() {
        String amount = "2000";
        assertThatCode(() -> AmountValidator.isAmount(amount)).doesNotThrowAnyException();
    }

}
