import java.util.Arrays;
import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        //Write a Stream Expression to get the average value of the odd numbers from the following list:
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        Double averageOfOddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToDouble(n -> n)
                .average()
                .getAsDouble();

        System.out.println(averageOfOddNumbers);

        Double averageOfOddNumbers2 = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .getAsDouble();

        System.out.println(averageOfOddNumbers2);

        Double averageOfOddNumbers3 = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToDouble(Integer::doubleValue)
                .summaryStatistics()
                .getAverage();

        System.out.println(averageOfOddNumbers3);
    }
}
