package fractals;

import java.awt.*;

public class Tree {
    double length;

    public Tree(int length) {
        this.length = length;
    }

    public void drawTree(int startX, int startY, double length, int angle, int anglechange, int level, Graphics graphics) {
        int endX = startX + (int) (Math.sin(Math.toRadians(angle)) * length);
        int endY = startY - (int) (Math.cos(Math.toRadians(angle)) * length);

        graphics.drawLine(startX, startY, endX, endY);

        if (level > 0) {
            drawTree(endX, endY, 9 * length / 10, angle, anglechange, level - 1, graphics);
            drawTree(endX, endY, 9 * length / 10, angle + anglechange, anglechange, level - 1, graphics);
            drawTree(endX, endY, 9 * length / 10, angle - anglechange, anglechange, level - 1, graphics);


        }

    }
}
