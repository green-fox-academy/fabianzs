public class DrawChessTable {
    public static void main(String[] args) {

        int rows = 8;

        /*////Draws the lines, i specifies in which line we are in
        for (int i = 0; i < rows; i++) {
            //Decides if it starts with a white or dark field
            if (i % 2 == 0) {
                for (int j = 0; j < rows; j++) {
                    if (j % 2 == 0) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } else {
                for (int k = 0; k < rows; k++) {
                    if (k % 2 == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("%");
                    }
                }
                System.out.println();
            }

        }*/

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if ((i + j) % 2 == 0 ) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }
}
