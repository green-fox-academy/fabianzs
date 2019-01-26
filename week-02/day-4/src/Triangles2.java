import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles2 {
    public static void mainDraw(Graphics graphics) {

        int base = 22;
        int height = 18;
        int element = 21;

        int origox = WIDTH / (element + element / 5);
        int origoy = HEIGHT - HEIGHT / (element + element / 5);


        for (int i = 0; i < element ; i++) {
            origox += base / 2;
            origoy -= height;
            for (int j = 0; j < element - i; j++) {
                drawTriangle(origox + j * base, origoy, base, height, graphics);
            }
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

    public static void drawTriangle(int startx, int starty, int base, int height, Graphics graphics) {

        graphics.drawLine(startx, starty, startx + base, starty);
        graphics.drawLine(startx + base, starty, startx + (base / 2), starty - height);
        graphics.drawLine(startx + (base / 2), starty - height, startx, starty);
    }

}
