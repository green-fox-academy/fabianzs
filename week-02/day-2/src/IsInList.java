import java.util.*;

public class IsInList{
    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        checkNums(list);
        // Check if list contains all of the following elements: 4,8,12,16
        // Create a method that accepts list as an input
        // it should return "true" if it contains all, otherwise "false"

        System.out.println(checkNums(list));

    }

    public static boolean checkNums (List<Integer> listToCheck) {
        boolean containsAll = false;

        for (int i = 0; i < listToCheck.size(); i++) {
            if (listToCheck.get(i) == 4) {
                for (int j = 0; j < listToCheck.size() ; j++) {
                    if (listToCheck.get(j) == 8) {
                        for (int k = 0; k < listToCheck.size() ; k++) {
                            if (listToCheck.get(k) == 12) {
                                for (int l = 0; l < listToCheck.size() ; l++) {
                                    if (listToCheck.get(l) == 16) {
                                        containsAll = true;
                                    }

                                }
                            }

                        }
                    }

                }
            }
        }
        return containsAll;
    }
}
