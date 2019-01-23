import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction2 {
    public static void mainDraw(Graphics graphics) {
        // Create a square drawing function that takes 3 parameters:
        // The square size, the fill color, graphics
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares.

        int size = 365;
        ArrayList<Color> rainbowColor = new ArrayList<>();

        rainbowColor.add(new Color(255, 0, 0));
        rainbowColor.add(new Color(255, 127, 0));
        rainbowColor.add(new Color(255, 255, 0));
        rainbowColor.add(new Color(0, 255, 0));
        rainbowColor.add(new Color(0, 0, 255));
        rainbowColor.add(new Color(75, 0, 130));
        rainbowColor.add(new Color(143, 0, 255));

        for (int i = 0; i < 7; i++) {
            size = size - 45;
            drawSquare(size, rainbowColor.get(i),  graphics);
        }



       /* for (int i = 0; i < WIDTH ; i++) {
            rainbow = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            size = i;
            drawSquare(size, rainbow,  graphics);
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

    public static void drawSquare (int size, Color rainbow, Graphics graphics) {
        graphics.setColor(rainbow);
        graphics.fillRect(WIDTH/2 - size/2, HEIGHT/2 - size/2, size, size);
    }
}