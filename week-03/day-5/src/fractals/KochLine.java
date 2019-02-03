package fractals;

import java.awt.*;

public class KochLine {
    int startX;
    int endX;
    int startY;
    int endY;

    public KochLine(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public static void drawKochLine(int startX, int startY, int endX, int endY, int level, Graphics graphics) {
        double sqrt3 = Math.sqrt(3) / 2;

        int deltaX = endX - startX;
        int deltaY = endY - startY;

        int x5 = endX;
        int y5 = endY;

        int x1 = startX;
        int y1 = startY;

        int x2 = x1 + deltaX / 3;
        int y2 = y1 + deltaY / 3;

        int x3 = (int) ((x1 + x5) / 2 - (y1 - y5) / 3 * sqrt3);
        int y3 = (int) ((y1 + y5) / 2 - (x5 - x1) / 3 * sqrt3);

        int x4 = x1 + 2 * deltaX / 3;
        int y4 = y1 + 2 * deltaY / 3;

        graphics.setColor(Color.WHITE);
        graphics.drawLine(x1, y1, x5, y5);

        graphics.setColor(Color.BLACK);
        graphics.drawLine(x1, y1, x2, y2);
        graphics.drawLine(x2, y2, x3, y3);
        graphics.drawLine(x3, y3, x4, y4);
        graphics.drawLine(x4, y4, x5, y5);

        if (level > 0) {
            drawKochLine(x1, y1, x2, y2, level - 1, graphics);
            drawKochLine(x2, y2, x3, y3, level - 1, graphics);
            drawKochLine(x3, y3, x4, y4, level - 1, graphics);
            drawKochLine(x4, y4, x5, y5, level - 1, graphics);
        }
    }
}
