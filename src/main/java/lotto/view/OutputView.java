package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public class OutputView {
    public void outputPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void outputTickets(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            String numbers = ticket.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + numbers + "]");
        }
    }

    public void outputStatistics(Map<Rank, Integer> winningResult) {
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank.getMatchNumbers() == 0) {
                continue;
            }
            System.out.println(rank.getMatchNumbers() +
                    rank.getMessage() +
                    " (" + nf.format(rank.getMatchAmount()) + "원" + ")" +
                    " - " + winningResult.get(rank) + "개");
        }
    }

    public void outputProfitRate(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
