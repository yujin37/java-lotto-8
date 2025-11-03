package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.NumberErrorMessage;

public class NumbersConverter {
    private final static String SPLIT_CHAR = ",";

    public static List<Integer> convertToNumbers(String numbers) {
        List<String> parsedNumbers = parseNumber(numbers);
        return convertNumber(parsedNumbers);

    }

    public static int convertToBonus(String number) {
        return convertInt(number.strip(), NumberErrorMessage.BONUS_NUMBER_NOT_NUMBER.getMessage());
    }

    private static List<String> parseNumber(String numbers) {
        return List.of(numbers.split(SPLIT_CHAR));
    }

    private static Integer convertInt(String number, String errorMessage) {
        try {
            return Integer.parseInt(number.strip());
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    //숫자를 위 함수에서 변환해서 넣어준다.
    private static List<Integer> convertNumber(List<String> numbers) {
        List<Integer> convertedNumber = new ArrayList<>();
        for (String num : numbers) {
            convertedNumber.add(convertInt(num.strip(), NumberErrorMessage.WINNING_NUMBERS_NOT_NUMBER.getMessage()));
        }
        return convertedNumber;
    }
}
