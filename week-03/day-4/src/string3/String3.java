package string3;

public class String3 {
    public static void main(String[] args) {

        // Given a string, compute recursively a new string where all the
        // adjacent chars are now separated by a "*".

        System.out.println(addStarForward("bfvidbfidbjldfbfjkdbjgklsdbyjké"));
        System.out.println(addStarBackward("bfvidbfidbjldfbfjkdbjgklsdbyjké"));

    }

    public static String addStarForward(String stringToChange) {
        if (stringToChange.length() > 1) {
            return stringToChange.charAt(0) + "*" + addStarForward(stringToChange.substring(1));
        }
        return stringToChange;
    }

    public static String addStarBackward(String stringToChange) {
        if (stringToChange.length() > 1) {
            return addStarBackward(stringToChange.substring(0, stringToChange.length() - 1)) + "*" + stringToChange.charAt(stringToChange.length() - 1);
        }
        return stringToChange;
    }
}
