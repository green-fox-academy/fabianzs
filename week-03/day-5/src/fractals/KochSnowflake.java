package fractals;

import java.awt.*;

public class KochSnowflake {
    int base;

    public KochSnowflake(int base) {
        this.base = base;
    }

    public void drawKochSnowflake(int origoX, int origoY, int base, int level, Graphics graphics) {
        int[][] coordinates = Triangle.calculateTriangleCoordinates(origoX, origoY, base);
        KochLine.drawKochLine(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1], level, graphics);
        KochLine.drawKochLine(coordinates[1][0], coordinates[1][1], coordinates[2][0], coordinates[2][1], level, graphics);
        KochLine.drawKochLine(coordinates[2][0], coordinates[2][1], coordinates[0][0], coordinates[0][1], level, graphics);

    }
}
