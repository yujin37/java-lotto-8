package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTotalTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전체_작동테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[1, 3, 5, 7, 9, 11]",
                            "[5, 6, 8, 10, 13, 21]",
                            "[30, 31, 32, 37, 38, 44]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(1, 3, 5, 7, 9, 11),
                List.of(5, 6, 8, 10, 13, 21),
                List.of(30, 31, 32, 37, 38, 44)
        );
    }

    @Test
    void 전체_당첨금액_에러() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 전체_당첨금액_통과_당첨번호_개수_에러() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 전체_당첨금액_통과_당첨번호_문자_에러() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, ~");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 전체_당첨금액_통과_당첨번호_통과_보너스번호_에러() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "!");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
