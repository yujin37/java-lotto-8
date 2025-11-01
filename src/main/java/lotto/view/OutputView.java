package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASE_SUCCESS = "개를 구매했습니다.";
    private static final String LINE_BREAK = "\n";
    private static final String TICKET_SPLIT_CHAR = ", ";
    private static final String VALUES_OPEN = "[";
    private static final String VALUES_CLOSE = "]";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String AMOUNT_OPEN = "(";
    private static final String AMOUNT_CLOSE = ")";
    private static final String AMOUNT_UNIT = "원";
    private static final String SPLIT_LINE = " - ";
    private static final String WINNING_UNIT = "개";
    private static final String PROFIT_PREFIX = "총 수익률은 ";
    private static final String PROFIT_SUFFIX = "%입니다.";

    public void outputPurchaseCount(int count) {
        System.out.println(LINE_BREAK + count + PURCHASE_SUCCESS);
    }

    public void outputTickets(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            String numbers = ticket.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(TICKET_SPLIT_CHAR));
            System.out.println(VALUES_OPEN + numbers + VALUES_CLOSE);
        }
    }

    public void outputStatistics(Map<Rank, Integer> winningResult) {
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(WINNING_STATISTICS);
        for (Rank rank : Rank.values()) {
            if (rank.getMatchNumbers() == 0) {
                continue;
            }
            System.out.println(rank.getMatchNumbers() +
                    rank.getMessage() +
                    AMOUNT_OPEN + nf.format(rank.getMatchAmount()) + AMOUNT_UNIT + AMOUNT_CLOSE +
                    SPLIT_LINE + winningResult.get(rank) + WINNING_UNIT);
        }
    }

    public void outputProfitRate(double profit) {
        System.out.println(PROFIT_PREFIX + profit + PROFIT_SUFFIX);
    }
}
