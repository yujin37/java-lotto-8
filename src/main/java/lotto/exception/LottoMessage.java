package lotto.exception;

public class LottoMessage {
    private LottoMessage() {
    }

    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String PURCHASE_SUCCESS = "개를 구매했습니다.";
    public static final String LINE_BREAK = "\n";
    public static final String TICKET_SPLIT_CHAR = ", ";
    public static final String VALUES_OPEN = "[";
    public static final String VALUES_CLOSE = "]";
    public static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    public static final String AMOUNT_OPEN = " (";
    public static final String AMOUNT_CLOSE = ")";
    public static final String AMOUNT_UNIT = "원";
    public static final String SPLIT_LINE = " - ";
    public static final String WINNING_UNIT = "개";
    public static final String PROFIT_PREFIX = "총 수익률은 ";
    public static final String PROFIT_SUFFIX = "%입니다.";

}
