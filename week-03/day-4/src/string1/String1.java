package string1;

public class String1 {
    public static void main(String[] args) {
        // Given a string, compute recursively (no loops) a new string where all the
        // lowercase 'x' chars have been changed to 'y' chars.

        String stringToChange = "nbjixijoypjixofnxsjdnyxxxxx";

        System.out.println(changeXToYBackward(stringToChange));
        System.out.println(changeXToYForward(stringToChange));


    }


    public static String changeXToYForward(String stringToChange) {
        if (stringToChange.length() > 0) {
            if (stringToChange.charAt(0) == 'x') {
                stringToChange = 'y' + stringToChange.substring(1);
            }
            return stringToChange.charAt(0) + changeXToYForward(stringToChange.substring(1));
        }
        return stringToChange;
    }

    public static String changeXToYBackward(String stringToChange) {
        if (stringToChange.length() > 1) {
            if (stringToChange.charAt(stringToChange.length()-1) == 'x') {
                stringToChange = stringToChange.substring(0, stringToChange.length() - 1) + "y";
            }
            return changeXToYBackward(stringToChange.substring(0, stringToChange.length() - 1)) + stringToChange.charAt(stringToChange.length() - 1);
        }
        return stringToChange;
    }

}
