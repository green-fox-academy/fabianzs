import java.util.Map;
import java.util.stream.Collectors;

public class Exercise9 {
    public static void main(String[] args) {
        //Write a Stream Expression to find the frequency of characters in a given string!
        String rainingStars = "Slow motion horror was everywhere";

        Map<Character, Long> characterFrequency = rainingStars.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Character::valueOf, Collectors.counting()));

        System.out.println(characterFrequency);

        Map<Character, Integer> characterFrequency2 = rainingStars.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.toMap(c1 -> c1, c1 -> 1, (c1, c2) -> c1 + c2));

        System.out.println(characterFrequency2);

        Map<Character, Integer> characterFrequency3 = rainingStars.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        System.out.println(characterFrequency3);
    }
}
