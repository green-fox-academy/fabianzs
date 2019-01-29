import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logs {
    public static void main(String[] args) {
        // Read all data from 'log.txt'.
        // Each line represents a log message from a web server
        // Write a function that returns an array with the unique IP adresses.
        // Write a function that returns the GET / POST request ratio.

        collectUniqueIP("log.txt");

        //for (String IP: collectUniqueIP("log.txt")) {
        //    System.out.println(IP);
        //}

        calculateRatioOfGetPostRequest("log.txt");
        //System.out.println(calculateRatioOfGetPostRequest("log.txt"));

    }

    public static String[] collectUniqueIP (String fileName) {
        Path pathOfFile = Paths.get(fileName);
        List<String> allIP = new ArrayList<>();
        List<String> uniqueIP = new ArrayList<>();

        try {
            List<String> allLines = Files.readAllLines(pathOfFile);

            for (String eachLine : allLines) {
                allIP.add(eachLine.substring(27, 39));
            }

            for (int i = 0; i < allIP.size() ; i++) {
                if (!uniqueIP.contains(allIP.get(i))) {
                    uniqueIP.add(allIP.get(i));
                }
            }

            String[] uniqueIPArr = new String[uniqueIP.size()];

            for (int i = 0; i < uniqueIPArr.length; i++) {
                uniqueIPArr[i] = uniqueIP.get(i);
            }


            return uniqueIPArr;

        } catch (IOException ex) {
            System.out.println("Unable to read file.");

            return new String[0];
        }
    }

    public static double calculateRatioOfGetPostRequest(String fileName) {
        Path pathOfFile = Paths.get(fileName);
        List<String> allRequest = new ArrayList<>();
        List<String> getRequest = new ArrayList<>();
        List<String> postRequest = new ArrayList<>();


        try {
            List<String> allLines = Files.readAllLines(pathOfFile);

            for (String eachLine : allLines) {
                allRequest.add(eachLine.substring(41));
            }

            for (int i = 0; i < allRequest.size() ; i++) {
                if (allRequest.get(i).contains("GET")) {
                    getRequest.add(allRequest.get(i));
                } else if (allRequest.get(i).contains("POST")) {
                    postRequest.add(allRequest.get(i));
                }
            }

            double ratioOfGetPostRequest = getRequest.size() / (double) postRequest.size();

            return ratioOfGetPostRequest;

        } catch (IOException ex) {
            System.out.println("Unable to read file.");

            return 0;
        }
    }
}
