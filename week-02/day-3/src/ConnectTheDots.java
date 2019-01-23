import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
    public static void mainDraw(Graphics graphics) {
        // Create a function that takes 2 parameters:
        // An array of {x, y} points and graphics
        // and connects them with green lines.
        // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
        // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
        // {120, 100}, {85, 130}, {50, 100}}

        int[][] arrayOfPoints1 = {{10, 10}, {290,  10}, {290, 290}, {10, 290}};
        int[][] arrayOfPoints2 = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};

        //dotConnecter(arrayOfPoints1, graphics);
        dotConnecter(arrayOfPoints2, graphics);

    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }

    public static void dotConnecter (int[][] dots, Graphics g ) {
        for (int i = 1; i < dots.length; i++) {
            for (int j = 1; j < dots[i].length; j++) {
                //System.out.print(dots[i][j] + " ");
                g.drawLine(dots[i-1][j-1], dots[i-1][j], dots[i][j-1], dots[i][j]);
            }
            //System.out.println(" ");
        }

        int lasti = dots.length - 1;
        int lastj = dots[lasti].length - 1;
        //System.out.println(dots[lasti][lastj]);

        g.drawLine(dots[lasti][lastj-1], dots[lasti][lastj], dots[0][0], dots[0][1]);
        //g.drawLine(dots[dots.length - 1][dots[dots.length - 1].length - 2], dots[dots.length - 1][dots[dots.length - 1].length - 1], dots[0][0], dots[0][1]);
    }
}