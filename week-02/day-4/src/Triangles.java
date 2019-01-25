import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void mainDraw(Graphics graphics) {

        int base = 22;
        int height = 18;
        int element = 21;
        int origox = WIDTH / (element + element / 5);
        int origoy = HEIGHT - HEIGHT / (element + element / 5);

        int startx;
        int starty;

        for (int i = 0; i < element ; i++) {
            startx = origox + i * base / 2;
            starty = origoy - i * height;
            drawLines(startx, starty, startx + (element - i) * base, starty, graphics);

            startx = origox + i * base;
            starty = origoy;
            drawLines(startx, starty, startx + (element - i) * base/2, starty - (element - i) * height, graphics);

            startx = origox + (element - i) * base;
            starty = origoy;
            drawLines(startx, starty, startx - (element -i) * base/2, starty - (element - i) * height, graphics);
        }
    }

    // Don't touch the code below
    static int WIDTH = 600;
    static int HEIGHT = 600;

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

    public static void drawLines (int startx, int starty, int endx, int endy, Graphics graphics) {
        graphics.drawLine(startx, starty, endx, endy);
    }

}
