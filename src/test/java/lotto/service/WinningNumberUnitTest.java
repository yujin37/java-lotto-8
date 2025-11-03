package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.exception.LottoMessage;
import lotto.util.CountConverter;
import lotto.util.NumbersConverter;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class WinningNumberUnitTest {

    @AfterEach
    void afterEach() {
        Console.close(); // 리소스 해제
    }

    @Test
    void 당첨번호_사용자_정상_입력_시() {
        //given
        String winningInput = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(winningInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        //when
        List<Integer> winningNumbers = service.checkNumbers();

        //then
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨번호_문자_입력시_에러발생() {
        //given
        String winningInput = "1,2,3,@,5,6\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(winningInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkNumbers();

        // then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.WINNING_MESSAGE);
    }

    @Test
    void 당첨번호_빈문자열_시_에러발생() {
        //given
        String winningInput = " \n1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(winningInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkNumbers();

        // then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.WINNING_MESSAGE);
    }

    @Test
    void 당첨번호_5개만_입력시_에러발생() {
        //given
        String winningInput = "1,2,3,4,5\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(winningInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkNumbers();

        // then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.WINNING_MESSAGE);
    }

    @Test
    void 당첨번호_중복_입력시_에러발생() {
        //given
        String winningInput = "1,2,3,4,5,5\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(winningInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkNumbers();

        // then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.WINNING_MESSAGE);
    }

    @Test
    void 당첨번호_범위가_아닌경우_에러발생() {
        //given
        String winningInput = "1,2,3,4,5,57\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(winningInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView,
                new CountConverter(),
                new NumbersConverter()
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkNumbers();

        // then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.WINNING_MESSAGE);
    }
}
