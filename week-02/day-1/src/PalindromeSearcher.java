import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeSearcher {
    public static void main(String[] args) {

        //Create a function named search palindrome following your current language's style guide.
        //It should take a string, search for palindromes that at least 3 characters long and
        // return a list with the found palindromes.

        String stringToSearch = "dog goat dad duck doodle never";
        System.out.println(searchPalindrome(stringToSearch));
    }

    public static ArrayList<String> searchPalindrome(String stringToSearch) {

        int numberOfPalindromes = 0;
        ArrayList<String> foundPalindrome = new ArrayList<>();

        for (int i = 1; i < stringToSearch.length() - 1; i++) {
            for (int j = 1; j <= i && j <= stringToSearch.length() - i; j++) {
                if (i - j >= 0 && i + j < stringToSearch.length()) {
                    char tempArray1[] = stringToSearch.substring(i - j, i + 1).toCharArray();
                    char tempArray2[] = stringToSearch.substring(i, i + j + 1).toCharArray();
                    Arrays.sort(tempArray1);
                    Arrays.sort(tempArray2);

                    if (Arrays.equals(tempArray1, tempArray2)) {
                        foundPalindrome.add(stringToSearch.substring(i - j, i + j + 1));
                    }
                }

                if (i - j >= 0 && i + 1 + j < stringToSearch.length()) {
                    char tempArray1[] = stringToSearch.substring(i - j, i + 1).toCharArray();
                    char tempArray2[] = stringToSearch.substring(i + 1, i + j + 2).toCharArray();
                    Arrays.sort(tempArray1);
                    Arrays.sort(tempArray2);

                    if (Arrays.equals(tempArray1, tempArray2)) {
                        foundPalindrome.add(stringToSearch.substring(i - j, i + j + 2));
                    }
                }
            }
        }

        return foundPalindrome;
    }
}

