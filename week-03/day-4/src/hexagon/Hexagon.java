package square;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(0,0, WIDTH, HEIGHT);

        graphics.setColor(Color.BLACK);

        int base = WIDTH/2;
        int level = 4;

        drawHexagon(WIDTH/2, WIDTH/2, base, level, graphics);
    }

    public static void drawHexagon(int origoX, int origoY, int base, int level, Graphics graphics) {
        int height = (int) (base * Math.sqrt(3)/2);

        if (level > 0) {

            int[] xPoints = {origoX - base, origoX - base / 2, origoX + base / 2, origoX + base, origoX + base / 2, origoX - base / 2};
            int[] yPoints = {origoY, origoY - height, origoY - height, origoY, origoY + height, origoY + height};

            graphics.drawPolygon(xPoints, yPoints, 6);

            drawHexagon(origoX - base/4, origoY - height/2, base/2, level - 1, graphics);
            drawHexagon(origoX + base/2, origoY, base/2, level - 1, graphics);
            drawHexagon(origoX - base/4, origoY + height/2, base/2, level - 1, graphics);
        }
    }


    // Don't touch the code below
    static int WIDTH = 450;
    static int HEIGHT = 450;

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
