import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar2 {
    public static void mainDraw(Graphics graphics) {
        int startx = 0;
        int starty = 0;
        int endx = 0;
        int endy = 0;

        int divide = 4;

        int constant = 20;

        int dividedSize = HEIGHT / divide;
        int dividedConstant = constant / divide;

        graphics.setColor(Color.ORANGE);

        for (int k = 0; k < HEIGHT; k+= 2 * dividedSize) {
            for (int j = 0; j < WIDTH; j += 2 * dividedSize) {
                for (int i = 0; i <= WIDTH / constant; i++) {

                    //Left bottom
                    drawLines(i * dividedConstant + j, dividedSize + k, dividedSize + j, (i + 1) * dividedConstant + dividedSize + k, graphics);
                    //Right bottom
                    drawLines(dividedSize + j, 2 * dividedSize - (i - 1) * dividedConstant + k, i * dividedConstant + dividedSize + j, dividedSize + k, graphics);
                    //Right up
                    drawLines(dividedSize + j, (i - 1) * dividedConstant + k, i * dividedConstant + dividedSize + j, dividedSize + k, graphics);
                    //Left up
                    drawLines(i * dividedConstant + j, dividedSize + k, dividedSize + j, dividedSize - (i + 1) * dividedConstant + k, graphics);
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

    public static void drawLines (int startx, int starty, int endx, int endy, Graphics graphics) {
        graphics.drawLine(startx, starty, endx, endy);
    }
}
