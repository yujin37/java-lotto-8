package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public List<List<Integer>> issueTicket(int count) {

        List<List<Integer>> tickets = new ArrayList<>();
        for(int i = 0; i < count ; i++) {
            List<Integer> numbers = GenerateNumbers.LottoNumbers();
            Collections.sort(numbers);
            tickets.add(numbers);
        }
        return tickets;
    }
}
