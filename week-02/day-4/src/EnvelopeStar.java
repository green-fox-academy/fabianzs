import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        int divide = 2;
        int spaceBetweenLines = 20;

        drawLines(2, 20, Color.ORANGE, graphics);
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


    public static void drawLines (int divide, int constant, Color color, Graphics graphics) {
        graphics.setColor(color);
        int numberOfLines = WIDTH / constant;
        int spaceBetweenLines = constant / divide;
        int sizeOfSquare = HEIGHT / divide;

        for (int i = 0; i <= numberOfLines; i++) {
            int currentStartingPoint = i * spaceBetweenLines;
            //Left bottom
            graphics.drawLine(currentStartingPoint, sizeOfSquare, sizeOfSquare, currentStartingPoint + sizeOfSquare);
            //Right bottom
            graphics.drawLine(sizeOfSquare, 2 * sizeOfSquare - currentStartingPoint, currentStartingPoint + sizeOfSquare, sizeOfSquare);
            //Right up
            graphics.drawLine(sizeOfSquare, currentStartingPoint, currentStartingPoint + sizeOfSquare, sizeOfSquare);
            //Left up
            graphics.drawLine(currentStartingPoint, sizeOfSquare, sizeOfSquare, sizeOfSquare - currentStartingPoint);
        }
    }
}
