package lotto.service;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Rank;

public class WinningResultFactory {
    public static Map<Rank, Integer> createInitialResult() {
        Map<Rank, Integer> resultWinning = new HashMap<>();
        for (Rank rank : Rank.values()) {
            resultWinning.put(rank, 0);
        }
        return resultWinning;
    }
}
