package string2;

public class String2 {
    public static void main(String[] args) {
        // Given a string, compute recursively a new string where all the 'x' chars have been removed.

        String stringToChange = "nbjixijoypjixofnsjdnyxxxx";

        System.out.println(removeXBackward(stringToChange));
        System.out.println(removeXForward(stringToChange));


    }


    public static String removeXForward(String stringToChange) {
        if (stringToChange.length() > 0) {
            if (stringToChange.charAt(0) == 'x') {
                stringToChange = removeXForward(stringToChange.substring(1));
            } else {
                stringToChange = stringToChange.charAt(0) + removeXForward(stringToChange.substring(1));
            }
        }
        return stringToChange;
    }

    public static String removeXBackward(String stringToChange) {
        if (stringToChange.length() > 0) {
            if (stringToChange.endsWith("x")) {
                stringToChange = removeXBackward(stringToChange.substring(0, stringToChange.length() - 1));
            } else {
                stringToChange = removeXBackward(stringToChange.substring(0, stringToChange.length() - 1)) + stringToChange.charAt(stringToChange.length() - 1);
            }
        }
        return stringToChange;
    }


}
