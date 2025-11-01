package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public void validateRange(List<Integer> numbers) {
        long filteredNumbers = numbers.stream()
                .filter(n -> (n >= 0 && n <= 45))
                .count();
        if (filteredNumbers != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 범위에 있지 않습니다. 반드시 1 ~ 45 사이의 숫자로 구성되어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
