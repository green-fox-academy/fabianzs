import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
    public static void mainDraw(Graphics graphics) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        int divide = 2;

        int constant = 20;

        for (int k = 0; k < HEIGHT; k+=HEIGHT/divide) {
            for (int j = 0; j < WIDTH; j+=WIDTH/divide) {
                graphics.setColor(Color.ORANGE);
                for (int i = 0; i < WIDTH/constant; i++) {
                    x1 = i * constant/divide + j;
                    y1 = 0 + k;
                    x2 = WIDTH/divide + j;
                    y2 = (i + 1) * constant/divide + k;

                    graphics.drawLine(x1, y1, x2, y2);

                }

                graphics.setColor(Color.GREEN);
                for (int i = 0; i < HEIGHT/constant ; i++) {
                    x1 = 0 + k;
                    y1 = i * constant/divide + j;
                    x2 = (i + 1) * constant/divide + k;
                    y2 = HEIGHT/divide + j;

                    graphics.drawLine(x1,y1,x2,y2);

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
}
