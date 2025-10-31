package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateNumbers {
    public static List<Integer> LottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
