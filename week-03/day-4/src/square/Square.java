package square;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Square {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(0,0, WIDTH, HEIGHT);


        graphics.setColor(Color.BLACK);

        drawSquare(WIDTH, WIDTH, WIDTH, graphics);
        //drawSquare2(WIDTH/2, WIDTH/2, WIDTH,graphics);
    }

    public static void drawSquare(int startX, int startY, int size, Graphics graphics) {
        if (size > 0) {

            graphics.drawRect(startX-size, startY-size, size, size);

            drawSquare(startX-size/3 , startY,size/3, graphics);
            drawSquare(startX , startY - size/3,size/3, graphics);
            drawSquare(startX-2*size/3 , startY - size/3,size/3, graphics);
            drawSquare(startX-size/3 , startY - 2*size/3,size/3, graphics);
        }
    }

    public static void drawSquare2 (int origoX, int origoY, int base, Graphics graphics) {
        if (base > 0) {

            int[] xPoints = {origoX - base / 2, origoX + base / 2, origoX + base / 2, origoX - base / 2};
            int[] yPoints = {origoY - base / 2, origoY - base / 2, origoY + base / 2, origoY + base / 2};

            graphics.drawPolygon(xPoints, yPoints, 4);

            drawSquare2(origoX - base/3, origoY,base/3, graphics);
            drawSquare2(origoX + base/3, origoY,base/3, graphics);
            drawSquare2(origoX, origoY - base/3,base/3, graphics);
            drawSquare2(origoX, origoY + base/3,base/3, graphics);
        }
    }


    // Don't touch the code below
    static int WIDTH = 729;
    static int HEIGHT = 729;

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
