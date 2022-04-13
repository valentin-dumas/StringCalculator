import java.util.List;

public class NegativeNumberException extends IllegalStateException {

    public NegativeNumberException(List<Integer> negatives) {
        System.out.println("negatives not allowed " + List.of(negatives));
    }
}