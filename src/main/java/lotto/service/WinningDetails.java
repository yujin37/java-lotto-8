package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import lotto.domain.Rank;

public class WinningDetails {
    public Map<Rank, Integer> calculateWinning(List<List<Integer>> tickets, List<Integer> winningNumbers, int bonus) {
        Map<Rank, Integer> resultWinning = new HashMap<>(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.LOSE, 0
        ));
        for(List<Integer> ticket : tickets) {
            long correctValue = guessNumbers(ticket, winningNumbers);
            boolean hasBonus = guessBonus(ticket, bonus);
            Rank rank = guessRank(correctValue, hasBonus);
            resultWinning.put(rank, resultWinning.get(rank)+1);
        }
        return resultWinning;
    }
    private long guessNumbers(List<Integer> ticket, List<Integer> winningNumbers) {
        return ticket.stream()
                .filter(t -> winningNumbers.stream()
                        .anyMatch(Predicate.isEqual(t)))
                .count();
    }
    private boolean guessBonus(List<Integer> ticket, int bonus) {
        return ticket.contains(bonus);
    }

    private Rank guessRank(long correct, boolean hasBonus) {
        if(correct == 3) return Rank.FIFTH;
        if(correct == 4) return Rank.FOURTH;
        if(correct == 5 && hasBonus == false) {
            return Rank.THIRD;
        }
        if(correct == 5 && hasBonus == true) {
            return Rank.SECOND;
        }
        if(correct == 6) return Rank.FIRST;

        return Rank.LOSE;
    }
}
