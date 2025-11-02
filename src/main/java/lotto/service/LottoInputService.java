package lotto.service;

import java.util.List;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;
import lotto.util.AmountValidator;
import lotto.util.BonusValidator;
import lotto.util.CountConverter;
import lotto.util.NumbersConverter;
import lotto.util.NumbersValidator;
import lotto.view.InputView;

public class LottoInputService {
    private final InputView inputView;
    private final CountConverter countConverter;
    private final NumbersConverter numbersConverter;

    // 생성자 주입
    public LottoInputService(InputView inputView,
                             CountConverter countConverter,
                             NumbersConverter numbersConverter) {
        this.inputView = inputView;
        this.countConverter = countConverter;
        this.numbersConverter = numbersConverter;
    }


    public int checkAmount() {
        while (true) {
            try {
                String purChaseAmount = inputView.inputPurchaseAmount();
                AmountValidator.isAmount(purChaseAmount);
                return countConverter.convertToCount(purChaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                throw e;
            }
        }
    }

    public List<Integer> checkNumbers() {
        while (true) {
            try {
                String winningNumber = inputView.inputWinningNumbers();
                //로또를 먼저 검증
                NumbersValidator.isNumbers(winningNumber);
                //로또 변환
                List<Integer> winningNumbers = numbersConverter.convertToNumbers(winningNumber);
                new Lotto(winningNumbers);
                return winningNumbers;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkBonus(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                //검증 자체는 동일
                NumbersValidator.isNumbers(bonusNumber);
                int bonus = numbersConverter.convertToBonus(bonusNumber);
                BonusValidator.validateBonus(winningNumbers, bonus);
                return bonus;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
