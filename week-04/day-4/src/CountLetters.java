import java.util.HashMap;

public class CountLetters {
    public HashMap<Character, Integer> countLetters(String string) {
        if (string == null) {
            throw new NullPointerException("The input cannot be null.");
        }
        HashMap<Character, Integer> lettersWithOccurence = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (!lettersWithOccurence.containsKey(string.charAt(i))) {
                lettersWithOccurence.put(string.charAt(i), 1);
            } else {
                lettersWithOccurence.put(string.charAt(i), lettersWithOccurence.get(string.charAt(i)) + 1);
            }
        }
        return lettersWithOccurence;
    }
}
