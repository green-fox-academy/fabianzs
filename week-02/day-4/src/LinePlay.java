import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics) {
        int startx;
        int starty;
        int endx;
        int endy;

        int constant = 20;

        for (int i = 0; i < WIDTH/constant; i++) {
           startx = i * constant;
           starty = 0;
           endx = WIDTH;
           endy = (i + 1) * constant;

           drawLines(startx, starty, endx, endy, Color.ORANGE, graphics);
           drawLines(starty, startx, endy, endx, Color.GREEN, graphics);
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
