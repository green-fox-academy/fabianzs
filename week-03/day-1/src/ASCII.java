import java.util.*;
import java.io.*;
import java.math.*;

//4
//5
//MANHATTAN
// #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ###
//# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   #
//### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ##
//# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #
//# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #

public class ASCII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        T =T.toUpperCase();

        String [][] chars= new String[H][27];
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            for(int j = 0; j < 27; j++){
                chars[i][j] = ROW.substring(j*L, (j+1) * L);
            }
        }

        char [] character = new char[T.length()];

        for (int i = 0; i < H; i++) {
            for(int j = 0; j < T.length(); j ++) {
                character[j] = T.charAt(j);
                character[j] -= 65;
                if(character[j] < 0 || character[j] > 26) {
                    character[j] = 26;
                }
                System.out.print(chars[i][character[j]]);
            }
            System.out.println();
        }
    }



    /**
     * Auto-generated code below aims at helping you parse
     * the standard input according to the problem statement.
     **/

}
