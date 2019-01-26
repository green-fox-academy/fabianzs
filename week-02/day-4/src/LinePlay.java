import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics) {


        int spaceBetweenLines = 20;
        int canvasSize = WIDTH;

        drawLines(spaceBetweenLines, canvasSize, Color.ORANGE, Color.GREEN, graphics);
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

    public static void drawLines (int spaceBetweenLines, int canvasSize, Color color1, Color color2, Graphics graphics) {

        int numberOfLines = canvasSize / spaceBetweenLines;

        for (int i = 0; i <= numberOfLines; i++) {
            int currentStartingPoint = i * spaceBetweenLines;

            graphics.setColor(color1);
            graphics.drawLine(currentStartingPoint, 0, canvasSize, currentStartingPoint);
            graphics.setColor(color2);
            graphics.drawLine(0, currentStartingPoint, currentStartingPoint, canvasSize);
        }
    }
}
