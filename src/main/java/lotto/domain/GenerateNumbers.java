package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbers {
    public List<Integer> LottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
