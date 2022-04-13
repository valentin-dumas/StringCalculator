import java.util.List;
import java.util.stream.Collectors;


public final class StringCalculator {

    private boolean hasNegativeNumbers(List<Integer> negatives) {
        return !negatives.isEmpty();
    }

    public int add(String numbers) {
        final StringParser stringParser = new StringParser();

        if (numbers.isEmpty()) {
            return 0;
        }

        final List<Integer> parsedNumbers = stringParser.parse(numbers);

        final List<Integer> negativeNumbers = parsedNumbers.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if (hasNegativeNumbers(negativeNumbers)) {
            throw new NegativeNumberException(negativeNumbers);
        }

        return parsedNumbers.stream().reduce(0, Integer::sum);
    }

}