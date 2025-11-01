package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateNumbers {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_CNT = 6;

    public static List<Integer> LottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_CNT);
    }
}
