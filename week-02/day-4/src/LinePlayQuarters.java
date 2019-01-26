import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
    public static void mainDraw(Graphics graphics) {
        int divide = 4;
        int canvasSize = WIDTH;
        int spaceBetweenLines = 20;

        drawLines2(divide, spaceBetweenLines, canvasSize,Color.ORANGE, Color.GREEN, graphics);
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

    public static void drawLines (int divide, int spaceBetweenLines, int canvasSize, Color color1, Color color2, Graphics graphics) {

        int numberOfLines = canvasSize / spaceBetweenLines;
        int sizeOfSquare = canvasSize / divide;

        for (int k = 0; k < divide ; k++) {
            for (int j = 0; j < divide; j++) {
                for (int i = 0; i <= numberOfLines; i++) {
                    int currentStartingPoint = i * spaceBetweenLines / divide;
                    int currentStartingPointFromXOfSquare = currentStartingPoint + j * sizeOfSquare;
                    int currentStartingPointFromYOfSquare = currentStartingPoint + k * sizeOfSquare;

                    graphics.setColor(color1);
                    graphics.drawLine(currentStartingPointFromXOfSquare, k * sizeOfSquare, (j + 1) * sizeOfSquare, currentStartingPointFromYOfSquare);
                    graphics.setColor(color2);
                    graphics.drawLine(j * sizeOfSquare, currentStartingPointFromYOfSquare, currentStartingPointFromXOfSquare, (k + 1) * sizeOfSquare);
                }
            }
        }
    }

    public static void drawLines2 (int divide, int spaceBetweenLines, int canvasSize, Color color1, Color color2, Graphics graphics) {

        int numberOfLines = canvasSize / spaceBetweenLines;
        int sizeOfSquare = canvasSize / divide;

        for (int k = 0; k < canvasSize ; k+= sizeOfSquare) {
            for (int j = 0; j < canvasSize; j+=sizeOfSquare) {
                for (int i = 0; i <= numberOfLines; i++) {
                    int currentStartingPoint = i * spaceBetweenLines / divide;

                    graphics.setColor(color1);
                    graphics.drawLine(currentStartingPoint + j, k, sizeOfSquare + j, currentStartingPoint + k);
                    graphics.setColor(color2);
                    graphics.drawLine(j, currentStartingPoint + k, currentStartingPoint + j, sizeOfSquare + k);
                }
            }
        }
    }
}
