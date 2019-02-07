public class Palindrome {
    public boolean isPalindrome(String string1, String string2) {
        if (string1.length() == string2.length()) {
            for (int i = 0; i < string1.length(); i++) {
                if (string1.charAt(i) != string2.charAt(string1.length() - 1 - i)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }
}
