package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void outputPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void outputTickets(List<List<Integer>> tickets) {
        for(List<Integer> ticket : tickets) {
            String numbers = ticket.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + numbers+"]");
        }
    }
}
