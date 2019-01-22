public class PalindormeBuilder {
    public static void main(String[] args) {
        String stringToPalindrome1 = "greenfox";
        String stringToPalindrome2 = "randomstring";
        String stirngToPalindrome3 = "doom";



        System.out.println(stringToPalindrome1 + " | " + palindromeBuilder(stringToPalindrome1));

        System.out.println(stringToPalindrome2 + " | " + palindromeBuilder(stringToPalindrome2));

        System.out.println(stirngToPalindrome3 + " | " + palindromeBuilder(stirngToPalindrome3));

    }

    public static String palindromeBuilder (String toPalindrome1) {
        char[] toPalindrome1Array = toPalindrome1.toCharArray();

        char[] toPalindrome2Array = new char[toPalindrome1Array.length];

        for (int i = 0; i < toPalindrome1Array.length ; i++) {
            toPalindrome2Array[i] = toPalindrome1Array [(toPalindrome1Array.length-1)-i];
        }

        String  palindrome2 = new String(toPalindrome2Array);

        String palindrome = toPalindrome1.concat(palindrome2);

        return palindrome;
    }
}
