package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public List<Lotto> issueTicket(int count) {

        List<Lotto> tickets = new ArrayList<>();
        for(int i = 0; i < count ; i++) {
            List<Integer> numbers = GenerateNumbers.LottoNumbers();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
        }
        return tickets;
    }
}
