package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;
import lotto.service.WinningDetails;
import org.junit.jupiter.api.Test;

public class WinningDetailsTest {
    @Test
    void 당첨결과_제대로_나오는지_확인() {
        //when
        WinningDetails winningDetails = new WinningDetails();

        List<List<Integer>> tickets = List.of(
                List.of(1, 2, 3, 4, 5, 6), //1등
                List.of(1, 2, 3, 4, 5, 8), //2등
                List.of(1, 2, 3, 4, 5, 10), //3등
                List.of(1, 2, 3, 4, 9, 10), //4등
                List.of(1, 2, 12, 13, 14, 15) // 없음
        );

        List<Integer> winningTickets = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 8;

        //then
        Map<Rank, Integer> resultWinning = winningDetails.calculateWinning(tickets, winningTickets, bonus);

        assertThat(resultWinning.get(Rank.FIRST)).isEqualTo(1);
        assertThat(resultWinning.get(Rank.SECOND)).isEqualTo(1);
        assertThat(resultWinning.get(Rank.THIRD)).isEqualTo(1);
        assertThat(resultWinning.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(resultWinning.get(Rank.FIFTH)).isEqualTo(0);
    }
}
