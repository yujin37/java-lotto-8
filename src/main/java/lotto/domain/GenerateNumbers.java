package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.exception.LottoConstants;

public class GenerateNumbers {

    public static List<Integer> LottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUM, LottoConstants.MAX_NUM,
                LottoConstants.LOTTO_CNT);
    }
}
