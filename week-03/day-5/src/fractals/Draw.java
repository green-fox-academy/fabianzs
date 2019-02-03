package fractals;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Draw {
    public static void mainDraw(Graphics graphics) {

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
        //sierpinskiCarpet.drawSierpinskiCarpet(WIDTH/3, WIDTH/3, sierpinskiCarpet.size, 6, graphics);

        SquareGrid squareGrid = new SquareGrid(WIDTH / 2, 16.0f);
        //squareGrid.drawSquareGrid(WIDTH/4, WIDTH/4, squareGrid.size, squareGrid.stroke, 4, graphics);

        KochLine kochLine = new KochLine(0, WIDTH / 2, WIDTH, WIDTH / 2);
        //kochLine.drawKochLine(0,WIDTH / 2, WIDTH, WIDTH/2,6, graphics);

        KochSnowflake kochSnowFlake = new KochSnowflake(5 * WIDTH / 6);
        //kochSnowFlake.drawKochSnowflake(WIDTH /2,WIDTH/2, kochSnowFlake.base, 6, graphics);

        KochSnowflake2 kochSnowflake2 = new KochSnowflake2(5 * WIDTH / 6);
        //kochSnowflake2.drawKochSnowflake2(WIDTH / 2, WIDTH / 2, kochSnowflake2.base, 8, graphics);

        Tree tree = new Tree(80);
        tree.drawTree(WIDTH / 2, 9 * WIDTH / 10, tree.length, 0, 30, 7, graphics);

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
