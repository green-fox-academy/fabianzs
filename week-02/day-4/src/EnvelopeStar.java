import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        int startx = 0;
        int starty = 0;
        int endx = 0;
        int endy = 0;

        int divide = 2;

        int constant = 20;

        int dividedSize = HEIGHT / divide;
        int dividedConstant = constant / divide;

        graphics.setColor(Color.ORANGE);

        //Left bottom
        for (int i = 0; i <= WIDTH/constant; i++) {
            startx = i * dividedConstant;
            starty = dividedSize;
            endx = dividedSize;
            endy = (i + 1) * dividedConstant + dividedSize;

            graphics.drawLine(startx, starty, endx, endy);
        }

        //Right bottom
        for (int i = 0; i < WIDTH/constant; i++) {
            startx = dividedSize;
            starty = 2 * dividedSize - i * dividedConstant;
            endx = (i + 1) * dividedConstant + dividedSize;
            endy = dividedSize;

            graphics.drawLine(startx, starty, endx, endy);
        }

        //Right up
        for (int i = 0; i < WIDTH/constant ; i++) {
            startx = dividedSize;
            starty = i * dividedConstant;
            endx = (i + 1) * dividedConstant + dividedSize;
            endy = dividedSize;

            graphics.drawLine(startx, starty, endx, endy);
        }

        //Left up
        for (int i = 0; i <= WIDTH/constant; i++) {
            startx = i * dividedConstant;
            starty = dividedSize;
            endx = dividedSize;
            endy = dividedSize - (i + 1) * dividedConstant;

            graphics.drawLine(startx, starty, endx, endy);
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
