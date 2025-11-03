package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.exception.LottoMessage;
import lotto.service.LottoInputService;
import lotto.util.CountConverter;
import lotto.util.NumbersConverter;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BonusUnitTest {
    @AfterEach
    void afterEach() {
        Console.close(); // 리소스 해제
    }

    @Test
    void 보너스번호_정상_입력() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusInput = "37\n";
        System.setIn(new ByteArrayInputStream(bonusInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        //when
        int bonus = service.checkBonus(winningNumbers);

        //then
        assertThat(bonus).isEqualTo(37);
    }

    @Test
    void 보너스번호_문자_입력시_에러발생() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusInput = "!\na\n7";
        System.setIn(new ByteArrayInputStream(bonusInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkBonus(winningNumbers);

        //then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.BONUS_MESSAGE);
    }

    @Test
    void 보너스번호_빈_문자열시_에러발생() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusInput = "\n \n7";
        System.setIn(new ByteArrayInputStream(bonusInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkBonus(winningNumbers);

        //then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.BONUS_MESSAGE);
    }

    @Test
    void 보너스번호_범위_벗어날경우_에러발생() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusInput = "57\n7";
        System.setIn(new ByteArrayInputStream(bonusInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkBonus(winningNumbers);

        //then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.BONUS_MESSAGE);
    }

    @Test
    void 보너스번호_당첨번호와_중복_에러발생() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusInput = "2\n7";
        System.setIn(new ByteArrayInputStream(bonusInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkBonus(winningNumbers);

        //then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.BONUS_MESSAGE);
    }
}
