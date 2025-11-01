package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<List<Integer>> issueTicket(int count) {

        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = GenerateNumbers.LottoNumbers();
            List<Integer> sortedNumbers = numbers.stream()
                    .sorted()
                    .toList();
            tickets.add(sortedNumbers);
        }
        return tickets;
    }
}
