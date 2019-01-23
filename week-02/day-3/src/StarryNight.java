import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
    public static void mainDraw(Graphics graphics) {
        // Draw the night sky:
        //  - The background should be black
        //  - The stars can be small squares
        //  - The stars should have random positions on the canvas
        //  - The stars should have random color (some shade of grey)

        graphics.fillRect(0,0,WIDTH,HEIGHT);

        int x;
        int y;
        int size;


        for (int i = 0; i < 2000 ; i++) {
            x = (int) (Math.random() * WIDTH);
            y = (int) (Math.random() * HEIGHT);
            size = (int) (Math.random() * 3);

            drawStars(x, y, size, graphics);
        }





    }

    // Don't touch the code below
    static int WIDTH = 1200;
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

    public static void drawStars (int x, int y, int size, Graphics graphics) {
        int c = (int) (Math.random() * 255);
        graphics.setColor(new Color(c, c, c));
        graphics.fillRect(x, y, size, size);
    }
}
