import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        int divide = 2;

        int constant = 20;

        graphics.setColor(Color.ORANGE);

        //Left bottom
        for (int i = 0; i <= WIDTH/constant; i++) {
            x1 = i * constant/divide;
            y1 = HEIGHT/divide;
            x2 = WIDTH/divide;
            y2 = (i + 1) * constant/divide + HEIGHT/divide;

            graphics.drawLine(x1, y1, x2, y2);
        }

        //Right bottom
        for (int i = 0; i < WIDTH/constant; i++) {
            x1 = WIDTH/divide;
            y1 = 2 * HEIGHT/divide - i * constant/divide;
            x2 = (i + 1) * constant/divide + WIDTH/divide;
            y2 = HEIGHT/divide;

            graphics.drawLine(x1, y1, x2, y2);
        }

        //Right up
        for (int i = 0; i < WIDTH/constant ; i++) {
            x1 = WIDTH/divide;
            y1 = i * constant/divide;
            x2 = (i + 1) * constant/divide + WIDTH/divide;
            y2 = HEIGHT/divide;

            graphics.drawLine(x1, y1, x2, y2);
        }

        //Left up
        for (int i = 0; i <= WIDTH/constant; i++) {
            x1 = i * constant/divide;
            y1 = HEIGHT/divide;
            x2 = WIDTH/divide;
            y2 = HEIGHT/divide - (i + 1) * constant/divide;

            graphics.drawLine(x1, y1, x2, y2);
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
}
