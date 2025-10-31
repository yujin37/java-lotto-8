package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    public void outputPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void outputTickets(List<Lotto> tickets) {
        for(Lotto ticket : tickets) {
            String numbers = ticket.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + numbers+"]");
        }
    }
}
