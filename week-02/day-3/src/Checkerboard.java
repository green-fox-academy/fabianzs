import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void mainDraw(Graphics graphics) {
        // Fill the canvas with a checkerboard pattern.

        int x = 0;
        int y = 0;

        for (int i = 0; i < 8; i++) {
            y = i * 40;
            for (int j = 0; j < 8; j++) {
                x = j * 40;
                if ((i + j) % 2 == 0) {
                    graphics.setColor(Color.ORANGE);
                } else {
                    graphics.setColor(Color.BLACK);
                }
                drawSquare(x, y, graphics);
            }
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



        String[][] chess = {
                {"x", " ", "x", " ", "x", " ", "x", " ",},
                {" ", "x", " ", "x", " ", "x", " ", "x",},
                {"x", " ", "x", " ", "x", " ", "x", " ",},
                {" ", "x", " ", "x", " ", "x", " ", "x",},
                {"x", " ", "x", " ", "x", " ", "x", " ",},
                {" ", "x", " ", "x", " ", "x", " ", "x",},
                {"x", " ", "x", " ", "x", " ", "x", " ",},
                {" ", "x", " ", "x", " ", "x", " ", "x",},
        };

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (chess[row][column] == "x") {
                } else {
                }
            }
        }
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }

    public static void drawSquare (int x, int y, Graphics graphics) {
        graphics.fillRect(x, y, 40, 40);
    }
}