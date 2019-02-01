package fractals;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Draw {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, WIDTH, HEIGHT);

        graphics.setColor(Color.BLACK);

        Triangle triangle = new Triangle(WIDTH);
        //triangle.drawTriangle(WIDTH/2, WIDTH/3, triangle.base, graphics);
        //triangle.drawTriangleFractal(WIDTH/2, WIDTH/3, triangle.base, 6, graphics);

        Circle circle = new Circle(WIDTH/2);
        //circle.drawCircle(0,0,circle.radius, graphics);
        //circle.drawCircleFractal(0, 0, circle.radius, 5, graphics);

        Hexagon hexagon = new Hexagon(WIDTH/2);
        //hexagon.drawHexagon(WIDTH/2, WIDTH/2, WIDTH/2, graphics);
        //hexagon.drawHexagonFractal(WIDTH/2, WIDTH/2, WIDTH/2, 6, graphics);

        SierpinskiCarpet sierpinskiCarpet = new SierpinskiCarpet(WIDTH/ 3);
        sierpinskiCarpet.drawSierpinskiCarpet(WIDTH/3, WIDTH/3, sierpinskiCarpet.size, 6, graphics);

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
