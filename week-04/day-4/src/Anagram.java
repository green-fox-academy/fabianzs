import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String string1, String string2) {
        if (string1 == "" || string1 == null || string2 == "" || string2 == null) {
            throw new NullPointerException("The input should contain two non-empty strings.");
        }
        String string1WithoutSpaces ="";
        String string2WithoutSpaces ="";
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != ' ') {
                string1WithoutSpaces += string1.charAt(i);
            }
        }
        for (int i = 0; i < string2.length(); i++) {
            if (string2.charAt(i) != ' ') {
                string2WithoutSpaces += string2.charAt(i);
            }
        }
        char[] string1Char = string1WithoutSpaces.toCharArray();
        char[] string2Char = string2WithoutSpaces.toCharArray();
        Arrays.sort(string1Char);
        Arrays.sort(string2Char);
        if (string1WithoutSpaces.length() == string2WithoutSpaces.length() && Arrays.equals(string1Char, string2Char)) {
            return true;
        }
        return false;
    }
}
