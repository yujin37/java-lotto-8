package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.NumberErrorMessage;

public class NumbersConverter {
    private List<String> parseNumber(String numbers) {
        return List.of(numbers.split(","));
    }

    private Integer convertInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NumberErrorMessage.WINNING_NUMBERS_NOT_NUMBER.getMessage());
        }
    }

    //숫자를 위 함수에서 변환해서 넣어준다.
    private List<Integer> convertNumber(List<String> numbers) {
        List<Integer> convertedNumber = new ArrayList<>();
        for(String num:numbers) {
            convertedNumber.add(convertInt(num));
        }
        return convertedNumber;
    }

    public List<Integer> convertToNumbers(String numbers) {
        List<String> parsedNumbers = parseNumber(numbers);
        return convertNumber(parsedNumbers);

    }
}
