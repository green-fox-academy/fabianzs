import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise8 {
    public static void main(String[] args) {
        //Write a Stream Expression to concatenate a Character list to a string!
        String quote = "The sky the deepest red, the sun the bleakest ";

        String finishedQuote = Arrays.asList('b', 'l', 'a', 'c', 'k').stream()
                .map(c -> c.toString())
                .collect(Collectors.joining("", quote, ""));

        System.out.println(finishedQuote);
    }
}
