package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    //로또 번호가 제대로 나왔는지 검증
    //1.중복이 있는가
    @Test
    void 중복이_있는가() {
        LottoMachine lottoMachine = new LottoMachine();
        List<List<Integer>> tickets = lottoMachine.issueTicket(1);
        List<Integer> ticket = tickets.get(0);
        long duplicateCount = ticket.stream().distinct().count();
        assertEquals(6, duplicateCount);
    }

    //2.6개로 제대로 나왔는가
    @Test
    void 지정한_로또_크기만큼_나왔는가() {
        LottoMachine lottoMachine = new LottoMachine();
        List<List<Integer>> tickets = lottoMachine.issueTicket(1);
        List<Integer> ticket = tickets.get(0);
        assertEquals(6, ticket.size());
    }

    //3.정렬이 되어있는가
    @Test
    void 정렬이_되었는가() {
        LottoMachine lottoMachine = new LottoMachine();
        List<List<Integer>> tickets = lottoMachine.issueTicket(1);
        List<Integer> ticket = tickets.get(0);
        assertThat(ticket).isSorted();
    }
}
