import java.util.Arrays;

public class DoubleItems {
    public static void main(String[] args) {
        // - Create an array variable named `numList`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Double all the values in the array

        int[] numList = {3, 4, 5, 6, 7};

        int[] newList = new int [2 * numList.length];

        for (int i = 0; i < 2 * numList.length ; i++) {
            if (i % 2 == 0) {
                newList[i] = numList[i / 2];
            }
            if (i % 2 == 1) {
                newList[i] = numList[i / 2];
            }
        }

        System.out.println(Arrays.toString(newList));

        for (int i = 0; i < numList.length ; i++) {
            numList[i] = 2 * numList[i];
        }

        System.out.println(Arrays.toString(numList));


    }
}
