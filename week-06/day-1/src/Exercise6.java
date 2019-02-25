import java.util.List;
import java.util.stream.Collectors;

public class Exercise6 {
    public static void main(String[] args) {
        //Write a Stream Expression to find the uppercase characters in a string!
        String test = "njHkdAnjKBHdkrml86.85J";

        List<Character> uppersCaseCharacters = test.chars()
                .filter(c -> Character.isUpperCase(c))
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        System.out.println(uppersCaseCharacters);
    }
}
