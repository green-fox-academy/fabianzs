import javax.swing.*;

import java.awt.*;
import java.util.Arrays;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots2 {
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
        //dotConnecter(arrayOfPoints2, graphics);

        int[] arrayX = new int[arrayOfPoints2.length];
        int[] arrayY = new int[arrayOfPoints2.length];

        for (int i = 0; i < arrayOfPoints2.length; i++) {
            arrayX[i] = arrayOfPoints2[i][0];
            arrayY[i] = arrayOfPoints2[i][1];
        }

        System.out.println(Arrays.toString(arrayX));
        System.out.println(Arrays.toString(arrayY));

        dotConnecter(arrayX, arrayY, graphics);

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

    public static void dotConnecter (int[] x, int[] y, Graphics g ) {
        g.setColor(new Color(0, 168, 107));
        g.drawPolygon(x, y, x.length);

    }
}