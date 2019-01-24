import java.lang.reflect.Array;

public class SubStrList {
    public static void main(String[] args) {
        //  Create a function that takes a string and a list of string as a parameter
        //  Returns the index of the string in the list where the first string is part of
        //  Only need to find the first occurence and return the index of that
        //  Returns `-1` if the string is not part any of the strings in the list

        //  Example
        String[] searchArr = new String[] {"this", "is", "what", "I'm", "searching"};


        System.out.println(subStrList2("ching", searchArr));
        //  should print: `4`
        System.out.println(subStrList2("not", searchArr));
        //  should print: `-1`
        System.out.println(subStrList2("ha", searchArr));
        System.out.println(subStrList2("'m", searchArr));
        System.out.println(subStrList2("whi", searchArr));

    }

    public static int subStrList (String subString, String[] searchArr) {

        for (int i = 0; i < searchArr.length; i++) {
            String stringToCheck = searchArr[i];
            if (stringToCheck.endsWith(subString)) {
                return i;
            } else {
                for (int j = 0; j < stringToCheck.length(); j++) {
                    String shorterString = stringToCheck.substring(0,stringToCheck.length()-j);
                    if (shorterString.endsWith(subString)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static int subStrList2 (String subString, String[] searchArr) {

        for (int i = 0; i < searchArr.length; i++) {
            String stringToCheck = searchArr[i];
            if (stringToCheck.contains(subString)) {
                return i;
            }
        }
        return -1;
    }
}