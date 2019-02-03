import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottery {

    public static void main(String[] args) {
        // Create a method that find the 5 most common lottery numbers in lottery.csv

        searchMostCommonLotteryNumbers("lottery.txt");
        System.out.println(Arrays.toString(searchMostCommonLotteryNumbers("lottery.txt")));

    }

    public static int[] searchMostCommonLotteryNumbers(String fileName) {
        Path fileToRead = Paths.get(fileName);

        try {
            List<String> allLotteryLines = new ArrayList<>();
            for (String lines : Files.readAllLines(fileToRead)) {
                allLotteryLines.add(lines);
            }

            String[][] allLotteryLinesArray = new String[allLotteryLines.size()][16];
            for (int i = 0; i < allLotteryLines.size(); i++) {
                allLotteryLinesArray[i] = allLotteryLines.get(i).split(";");
            }


            List<Integer> lotteryNumbers = new ArrayList<>();
            for (int i = 0; i < allLotteryLines.size(); i++) {
                lotteryNumbers.add(Integer.parseInt(allLotteryLinesArray[i][allLotteryLinesArray[0].length - 5]));
                lotteryNumbers.add(Integer.parseInt(allLotteryLinesArray[i][allLotteryLinesArray[0].length - 4]));
                lotteryNumbers.add(Integer.parseInt(allLotteryLinesArray[i][allLotteryLinesArray[0].length - 3]));
                lotteryNumbers.add(Integer.parseInt(allLotteryLinesArray[i][allLotteryLinesArray[0].length - 2]));
                lotteryNumbers.add(Integer.parseInt(allLotteryLinesArray[i][allLotteryLinesArray[0].length - 1]));
            }

            int[] mostFrequentElements = new int[5];

            for (int i = 0; i < mostFrequentElements.length; i++) {
                int mostFrequentElement = findMostFrequentElement(lotteryNumbers);
                clearValues(lotteryNumbers, mostFrequentElement);
                mostFrequentElements[i] = mostFrequentElement;
            }

            return mostFrequentElements;

        } catch (IOException ex) {
            return new int[0];
        }

    }

    public static int findMostFrequentElement(List<Integer> listToSearch) {
        int counter;
        int numberOfRepeats = 0;
        int mostFrequentElement = 0;

        for (int i = 0; i < listToSearch.size(); i++) {
            counter = 0;
            for (int j = i + 1; j < listToSearch.size(); j++) {
                if (listToSearch.get(i) == listToSearch.get(j) && listToSearch.get(i) != 0) {
                    counter++;
                }
            }

            if (counter > numberOfRepeats) {
                numberOfRepeats = counter;
                mostFrequentElement = listToSearch.get(i);
            }
        }

        return mostFrequentElement;

    }

    public static void clearValues(List<Integer> listToClear, int valueToClear) {
        for (int i = 0; i < listToClear.size(); i++) {
            if (valueToClear == listToClear.get(i)) {
                listToClear.set(i, 0);
            }
        }
    }
}