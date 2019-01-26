import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar2 {
    public static void mainDraw(Graphics graphics) {

        int divide = 4;
        int spaceBetweenLines = 20;

        drawLines(divide, spaceBetweenLines, Color.ORANGE, graphics);
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

    public static void drawLines (int divide, int spaceBetweenLines, Color color, Graphics graphics) {
        int dividedSize = HEIGHT / divide;
        int dividedSpaceBetweenLines = spaceBetweenLines / divide;

        graphics.setColor(color);

        for (int k = 0; k < HEIGHT; k+= 2 * dividedSize) {
            for (int j = 0; j < WIDTH; j += 2 * dividedSize) {
                for (int i = 0; i <= WIDTH / spaceBetweenLines; i++) {
                    int currentStartingPoint = i * dividedSpaceBetweenLines;

                    //Left bottom
                    graphics.drawLine(currentStartingPoint + j, dividedSize + k, dividedSize + j, currentStartingPoint + dividedSize + k);
                    //Right bottom
                    graphics.drawLine(dividedSize + j, 2 * dividedSize - currentStartingPoint + k, i * dividedSpaceBetweenLines + dividedSize + j, dividedSize + k);
                    //Right up
                    graphics.drawLine(dividedSize + j, i * dividedSpaceBetweenLines + k, i * dividedSpaceBetweenLines + dividedSize + j, dividedSize + k);
                    //Left up
                    graphics.drawLine(i * dividedSpaceBetweenLines + j, dividedSize + k, dividedSize + j, dividedSize - i * dividedSpaceBetweenLines + k);
                }
            }
        }
    }
}
