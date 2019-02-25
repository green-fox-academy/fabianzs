import java.util.Arrays;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        //Write a Stream Expression to get the sum of the odd numbers in the following list:
        List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);

        Integer sumOfOddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(n -> n)
                .sum();

        System.out.println(sumOfOddNumbers);

        Integer sumOfOddNumbers2 = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.println(sumOfOddNumbers2);

        Long sumOfOddNumbers3 = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::valueOf)
                .summaryStatistics()
                .getSum();

        System.out.println(sumOfOddNumbers3);
    }
}
