package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AmoutValidatorTest {
    //에러 메시지
    //1. 너무 큰 입력
    @Test
    void 구매금액이_매우_큰_경우() {
      int amount = 101000; // 10만 1000원
      assertThatThrownBy(() -> AmountValidator.);
    }
    //2. 작은 입력
    @Test
    void 구매금액이_너무_작은_경우() {
        //음수, 0, 1000원미만 동시 테스트
    }
    //3. 문자 입력(특수문자, 알파벳, 한글)
    @Test
    void 구매금액이_문자로_들어온_경우() {

    }
    //4. 빈 입력("", " ")
    @Test
    void 구매금액이_비어있는_경우() {
        //"", " " 테스트
    }
    //5. 나누어 떨어지지 않는
    @Test
    void 구매금액이_나누어_떨어지지_않는 경우() {

    }
    //에러 없는
    //1. 앞뒤 공백있으나 정상 입력
    //2. 나누어 떨어지는 숫자(1000원 단위)
}
