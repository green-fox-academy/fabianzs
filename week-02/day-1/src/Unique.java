import java.util.ArrayList;
import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once

        //  Example
        /*System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));*/
        //  should print: `[1, 11, 34, 52, 61]`

        int[] listOfNumbers = {1, 11, 34, 11, 52, 61, 1, 34};

        System.out.println(Arrays.toString(unique(listOfNumbers)));

    }

    public static int[] unique (int[] list) {

        int[] uniqueElements = new int[list.length];
        int numberOfUniqueElements = 0;

        for (int i = 0; i < list.length ; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j]) {
                    uniqueElements[i]++;
                }
            }

            if (uniqueElements[i] == 0) {
                numberOfUniqueElements++;
            }
        }

        int[] uniqueNumbers = new int[numberOfUniqueElements];

        int indexOfUniqueNumbers = 0;
        for (int i = 0; i < list.length; i++) {
            if (uniqueElements[i] == 0) {                
                uniqueNumbers[indexOfUniqueNumbers] = list[i];
                indexOfUniqueNumbers++;
            }
        }

        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;

    }
}
