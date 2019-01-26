import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String input1 = "god";
        String input2 = "dog";

        isAnagram(input1, input2);

        System.out.println(input1 + " | " + input2 + " | " + isAnagram(input1, input2));
    }

    public static boolean isAnagram (String s1, String s2) {

        if (s1.length() == s2.length()) {
            char[] s1Array = s1.toCharArray();
            char[] s2Array = s2.toCharArray();

            Arrays.sort(s1Array);
            Arrays.sort(s2Array);

            if(Arrays.equals(s1Array, s2Array)) {
                return true;
            }
        }
        return false;
    }
}


