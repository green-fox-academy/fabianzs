import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        // Create a line drawing function that takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.

        int pixel = 20;
        int x;
        int y;

        if (WIDTH % pixel == 0) {
            for (int i = 0; i <= WIDTH / pixel; i++) {
                for (int j = 0; j <= HEIGHT / pixel; j++) {
                    x = i * pixel;
                    y = j * pixel;

                    if (x == 0 || y == 0 || x == WIDTH || y == HEIGHT) {
                        lineDrawer(x, y, graphics);
                    }
                }
            }
        } else {
            System.out.println("Pick a pixel size that is divisor of 320.");
        }

        /*for (int i = 0; i <= WIDTH/pixel; i++) {

            x = i * pixel;
            y = 0;

            lineDrawer(x, y, graphics);

            x = WIDTH;
            y = i * pixel;

            lineDrawer(x, y, graphics);

            x = i * pixel;
            y = HEIGHT;

            lineDrawer(x, y, graphics);

            x = 0;
            y = i * pixel;

            lineDrawer(x, y, graphics);
        }*/





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

    public static void lineDrawer (int x, int y, Graphics graphics) {
        graphics.drawLine(x,y,WIDTH/2, HEIGHT/2);
    }
}