package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.exception.LottoMessage;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AmountUnitTest {

    @AfterEach
    void afterEach() {
        Console.close(); // 리소스 해제
    }

    @Test
    void 구매금액_정상입력인_경우() {
        //given
        String amountInput = "2000\n";
        System.setIn(new ByteArrayInputStream(amountInput.getBytes()));

        InputView inputView = new InputView();

        LottoInputService service = new LottoInputService(
                inputView
        );

        //when
        int amount = service.checkAmount();

        //then
        assertThat(amount).isEqualTo(2);
    }

    @Test
    void 구매금액_범위가_아닌경우_에러발생() {
        //given
        String amountInput = "-2000\n100\n101000\n1000\n";
        System.setIn(new ByteArrayInputStream(amountInput.getBytes()));

        InputView inputView = new InputView();
        LottoInputService service = new LottoInputService(
                inputView
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkAmount();

        //then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.PURCHASE_MESSAGE);
    }

    @Test
    void 구매금액_문자가_들어온경우_에러발생() {
        //given
        String amountInput = "2000!\n2000a\n2000원\n2000\n";
        System.setIn(new ByteArrayInputStream(amountInput.getBytes()));

        InputView inputView = new InputView();
        LottoInputService service = new LottoInputService(
                inputView
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkAmount();

        //then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.PURCHASE_MESSAGE);
    }

    @Test
    void 구매금액_빈_문자열시_에러발생() {
        //given
        String amountInput = "\n \n2000";
        System.setIn(new ByteArrayInputStream(amountInput.getBytes()));

        InputView inputView = new InputView();
        LottoInputService service = new LottoInputService(inputView);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        service.checkAmount();

        //then
        assertThat(out.toString()).contains("[ERROR]");
        assertThat(out.toString()).contains(LottoMessage.PURCHASE_MESSAGE);
    }
}
