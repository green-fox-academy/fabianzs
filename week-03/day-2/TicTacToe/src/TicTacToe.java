import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {

    public static void main(String[] args) {
        // Write a function that takes a filename as a parameter
        // The file contains an ended Tic-Tac-Toe match
        // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
        // Return "X", "O" or "Draw" based on the input file

        System.out.println(ticTacResult("win-o.txt"));
        // Should print "O"

        System.out.println(ticTacResult("win-x.txt"));
        // Should print "X"

        System.out.println(ticTacResult("draw.txt"));
        // Should print "Draw"
    }

    public static String ticTacResult (String fileName) {
        Path filePath = Paths.get(fileName);

        try {
            String[][] ticTacMatchMatrix = new String[3][3];
            List<String> ticTacMatchLine = Files.readAllLines(filePath);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    ticTacMatchMatrix[i][j] = ticTacMatchLine.get(i).substring(j, j + 1);
                }
            }


            for (int i = 0; i <ticTacMatchMatrix.length ; i++) {
                if (ticTacMatchMatrix[i][0].equals(ticTacMatchMatrix[i][1]) && ticTacMatchMatrix[i][1].equals(ticTacMatchMatrix[i][2])){
                    return ticTacMatchMatrix[i][0];
                } else if (ticTacMatchMatrix[0][i].equals(ticTacMatchMatrix[1][i]) && ticTacMatchMatrix[1][i].equals(ticTacMatchMatrix[2][i])) {
                    return ticTacMatchMatrix[0][i];
                }else if (ticTacMatchMatrix[0][0].equals(ticTacMatchMatrix[1][1]) && ticTacMatchMatrix[1][1].equals(ticTacMatchMatrix[2][2])){
                    return ticTacMatchMatrix[0][0];
                }
            }

            return "Draw";



        } catch (IOException ex) {
            System.out.println("Unable to read file.");

            return "";
        }

    }

    /*public static String ticTacResult2 (String fileName) {
        Path filePath = Paths.get(fileName);

        try {
            List<String> ticTacMatchLine = Files.readAllLines(filePath);
            String[][] ticTacMatchMatrix = new String[ticTacMatchLine.size()][ticTacMatchLine.get(0).length()];
            for (int i = 0; i < ticTacMatchLine.size(); i++) {
                for (int j = 0; j < ticTacMatchLine.get(i).length(); j++) {
                    ticTacMatchMatrix[i][j] = ticTacMatchLine.get(i).substring(j, j + 1);
                }
            }


            int similarInDiagonal = 0;

            for (int i = 0; i < ticTacMatchMatrix.length ; i++) {
                int similarInRow = 0;
                int similarInColumn = 0;
                for (int j = 0; j < ticTacMatchMatrix.length; j++) {
                    if (ticTacMatchMatrix[i][j].equals("O")) {
                        similarInRow++;
                        if (similarInRow == ticTacMatchMatrix.length) {
                            return ticTacMatchMatrix[i][j];
                        }
                    }

                    if (ticTacMatchMatrix[j][i].equals("O")) {
                        similarInColumn++;
                        if (similarInColumn == ticTacMatchMatrix.length) {
                            return ticTacMatchMatrix[j][i];
                        }
                    }

                    if (i == j && ticTacMatchMatrix[i][j].equals("O")) {
                        similarInDiagonal++;
                        if (similarInDiagonal == ticTacMatchMatrix.length) {
                            return ticTacMatchMatrix[i][j];
                        }

                    }
                }
            }

            similarInDiagonal = 0;
            for (int i = 0; i < ticTacMatchMatrix.length ; i++) {
                int similarInRow = 0;
                int similarInColumn = 0;
                for (int j = 0; j < ticTacMatchMatrix.length; j++) {
                    if (ticTacMatchMatrix[i][j].equals("X")) {
                        similarInRow++;
                        if (similarInRow == ticTacMatchMatrix.length) {
                            return ticTacMatchMatrix[i][j];
                        }
                    }

                    if (ticTacMatchMatrix[j][i].equals("X")) {
                        similarInColumn++;
                        if (similarInColumn == ticTacMatchMatrix.length) {
                            return ticTacMatchMatrix[j][i];
                        }
                    }

                    if (i == j && ticTacMatchMatrix[i][j].equals("X")) {
                        similarInDiagonal++;
                        if (similarInDiagonal == ticTacMatchMatrix.length) {
                            return ticTacMatchMatrix[i][j];
                        }

                    }
                }
            }

            return "Draw";

        } catch (IOException ex) {
            System.out.println("Unable to read file.");

            return "";
        }

    }*/
}