import java.util.List;

public class Sum {

    public int sum(List<Integer> numbers) {
        if (numbers == null) {
            throw new NullPointerException("Input is null.");
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
