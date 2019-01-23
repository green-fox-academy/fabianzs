import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {
    public static void mainDraw(Graphics graphics) {
        // Create a line drawing function that takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a 50 long horizontal line from that point.
        // Draw 3 lines with that function. Use loop for that.

        Scanner scanner = new Scanner(System.in);

        int x;
        int y;

        for (int i = 0; i < 3 ; i++) {
            System.out.println("Give the starting point of a line, x and y: ");
            x = scanner.nextInt();
            y = scanner.nextInt();

            drawLine(x,y,graphics);
        }



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

    public static void drawLine (int x, int y, Graphics graphics) {
        graphics.drawLine(x, y, x + 50, y);
    }
}