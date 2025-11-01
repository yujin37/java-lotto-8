package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Rank;
import lotto.service.ProfitCalculator;
import org.junit.jupiter.api.Test;

public class ProfitCalculateTest {
    @Test
    void 수익륙_계산_테스트() {
        //when
        ProfitCalculator profitCalculator = new ProfitCalculator();

        Map<Rank, Integer> winningResult = new HashMap<>();
        winningResult.put(Rank.FIRST, 0);
        winningResult.put(Rank.SECOND, 0);
        winningResult.put(Rank.THIRD, 1);
        winningResult.put(Rank.FOURTH, 0);
        winningResult.put(Rank.FIFTH, 0);

        int count = 10;

        // then
        double profit = profitCalculator.calculateProfitRate(winningResult, count);
        assertThat(profit).isEqualTo(15000.0);
    }

}
