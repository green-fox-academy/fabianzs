import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubInt {
    public static void main(String[] args) {
        //  Create a function that takes a number and a list of numbers as a parameter
        //  Returns the indexes of the numbers in the list where the first number is part of
        //  Returns an empty list if the number is not part any of the numbers in the list

        //  Example:
        //System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
        //  should print: `[0, 1, 4]`
        //System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
        //  should print: '[]'

        int subInteger = 1;
        ArrayList<Integer> numberArray = new ArrayList<>(Arrays.asList(1, 11, 34, 52, 61));

        System.out.println(findSubInt(subInteger, numberArray));
        System.out.println(findSubInt2(subInteger, numberArray));
    }

    public static List<Integer> findSubInt (int subInteger, List<Integer> numberArray) {

        ArrayList<String> stringArray = new ArrayList<>();
        String subString = String.valueOf(subInteger);

        ArrayList<Integer> listToReturn = new ArrayList<>();

        for (int i = 0; i < numberArray.size(); i++) {
            stringArray.add(String.valueOf(numberArray.get(i)));
            String stringToCheck = stringArray.get(i);
            if (stringToCheck.contains(subString)) {
                listToReturn.add(i);
            }
        }
        return listToReturn;
    }

    public static List<Integer> findSubInt2 (int subInteger, List<Integer> numberArray) {

        ArrayList<Integer> listToReturn = new ArrayList<>();

        for (int i = 0; i < numberArray.size(); i++) {
           int integerToCheck = numberArray.get(i);

           if (integerToCheck == subInteger) {
               listToReturn.add(i);
            } else {
               while (integerToCheck > subInteger) {
                   if (integerToCheck % 10 == subInteger) {
                       listToReturn.add(i);
                   }
                   integerToCheck = integerToCheck / 10;
               }
           }
        }
        return listToReturn;
    }
}