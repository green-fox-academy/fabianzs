package fractals;

import java.awt.*;

public class KochSnowflake2 {
    int base;

    public KochSnowflake2(int base) {
        this.base = base;
    }

    public void drawKochSnowflake2(int origoX, int origoY, int base, int level, Graphics graphics) {
        int height = (int) (base * Math.sqrt(3)/2);

        Triangle.fillTriangleDown(origoX, origoY, base, graphics);
        Triangle.fillTriangleUp(origoX, origoY, base, graphics);

        if (level > 0) {
            drawKochSnowflake2(origoX, origoY - 4 * height / 9, base / 3, level - 1, graphics);
            drawKochSnowflake2(origoX, origoY + 4 * height / 9, base / 3, level - 1, graphics);
            drawKochSnowflake2(origoX - base / 3, origoY - 2 * height / 9, base / 3, level - 1, graphics);
            drawKochSnowflake2(origoX + base / 3, origoY - 2 * height / 9, base / 3, level - 1, graphics);
            drawKochSnowflake2(origoX - base / 3, origoY + 2 * height / 9, base / 3, level - 1, graphics);
            drawKochSnowflake2(origoX + base / 3, origoY + 2 * height / 9, base / 3, level - 1, graphics);

        }
    }
}
