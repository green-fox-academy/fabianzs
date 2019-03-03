import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(solveJosephusProblem(1, 2));
        System.out.println(solveJosephusProblem(2, 2));
        System.out.println(solveJosephusProblem(3, 2));
        System.out.println(solveJosephusProblem(4, 2));
        System.out.println(solveJosephusProblem(7, 2));
        System.out.println(solveJosephusProblem(12, 2));
        System.out.println(solveJosephusProblem(41, 2));
    }

    public static int solveJosephusProblem(int numberOfPeople, int step) {
        List<Integer> prisoners = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            prisoners.add(i);
        }

        int indexToKill = 1 - step;
        while (prisoners.size() > 1) {
            indexToKill = (indexToKill + step) % prisoners.size();
            prisoners.remove(indexToKill);
            indexToKill--;
        }
        return prisoners.get(0) + 1;
    }

    public static int solveJosephusProblemWithRecursion(int numberOfPeople, int step) {
        if (numberOfPeople > 1) {
            return (solveJosephusProblemWithRecursion(numberOfPeople - 1, step) + step - 1) % numberOfPeople + 1;
        }
        return numberOfPeople;
    }
}
