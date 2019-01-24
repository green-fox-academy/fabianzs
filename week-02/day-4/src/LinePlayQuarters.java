import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
    public static void mainDraw(Graphics graphics) {
        int startx;
        int starty;
        int endx;
        int endy;

        int divide = 4;
        int constant = 20;
        int dividedSize = HEIGHT / divide;
        int dividedConstant = constant / divide;

        for (int k = 0; k < HEIGHT; k+=dividedSize) {
            for (int j = 0; j < WIDTH; j+=dividedSize) {
                graphics.setColor(Color.ORANGE);
                for (int i = 0; i < WIDTH/constant; i++) {
                    startx = i * dividedConstant + j;
                    starty = 0 + k;
                    endx = dividedSize + j;
                    endy = (i + 1) * dividedConstant + k;

                    drawLines(startx, starty, endx, endy, Color.ORANGE, graphics);
                    drawLines(starty, startx, endy, endx, Color.GREEN, graphics);
                }
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
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }

    public static void drawLines (int startx, int starty, int endx, int endy, Color color, Graphics graphics) {
        graphics.setColor(color);
        graphics.drawLine(startx, starty, endx, endy);
    }
}
