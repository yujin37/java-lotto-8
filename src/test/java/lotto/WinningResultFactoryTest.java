package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.domain.Rank;
import lotto.service.WinningResultFactory;
import org.junit.jupiter.api.Test;

public class WinningResultFactoryTest {
    //초기화 잘되는지 확인한다.
    @Test
    void 당첨결과_기록을_위한_맵_초기화_확인() {
        //given, when
        Map<Rank, Integer> winningMaps = WinningResultFactory.createInitialResult();

        //then
        assertThat(winningMaps).isNotEmpty();
        assertThat(winningMaps.keySet()).containsExactlyInAnyOrder(Rank.FIRST, Rank.SECOND, Rank.THIRD,
                Rank.FOURTH, Rank.FIFTH, Rank.LOSE);
        assertThat(winningMaps.values()).allMatch(n -> n == 0);
    }
}
