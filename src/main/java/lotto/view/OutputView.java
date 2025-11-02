package lotto.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;
import lotto.exception.LottoMessage;

public class OutputView {
    private static final DecimalFormat df = new DecimalFormat("#,###.#");

    public void outputPurchaseCount(int count) {
        System.out.println(LottoMessage.LINE_BREAK + count + LottoMessage.PURCHASE_SUCCESS);
    }

    public void outputTickets(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            String numbers = ticket.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(LottoMessage.TICKET_SPLIT_CHAR));
            System.out.println(LottoMessage.VALUES_OPEN + numbers + LottoMessage.VALUES_CLOSE);
        }
    }

    public void outputStatistics(Map<Rank, Integer> winningResult) {
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(LottoMessage.WINNING_STATISTICS);
        for (Rank rank : Rank.values()) {
            if (rank.getMatchNumbers() == 0) {
                continue;
            }
            System.out.println(rank.getMatchNumbers() +
                    rank.getMessage() +
                    LottoMessage.AMOUNT_OPEN + nf.format(rank.getMatchAmount()) + LottoMessage.AMOUNT_UNIT
                    + LottoMessage.AMOUNT_CLOSE +
                    LottoMessage.SPLIT_LINE + winningResult.get(rank) + LottoMessage.WINNING_UNIT);
        }
    }

    public void outputProfitRate(double profit) {
        System.out.println(LottoMessage.PROFIT_PREFIX + df.format(profit) + LottoMessage.PROFIT_SUFFIX);
    }
}
