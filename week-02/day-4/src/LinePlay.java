import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

       int constant = 20;

       graphics.setColor(Color.ORANGE);
       for (int i = 0; i < WIDTH/constant; i++) {
           x1 = i * constant;
           y1 = 0;
           x2 = WIDTH;
           y2 = (i + 1) * constant;

           graphics.drawLine(x1, y1, x2, y2);
       }

       graphics.setColor(Color.GREEN);
       for (int i = 0; i < HEIGHT/constant ; i++) {
           x1 = 0;
           y1 = i * constant;
           x2 = (i + 1) * constant;
           y2 = HEIGHT;

           graphics.drawLine(x1,y1,x2,y2);
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
