package fractals;

import java.awt.*;

public class Hexagon {
    int base;

    public Hexagon(int base) {
        this.base = base;
    }

    public void drawHexagon(int xOfFocus, int yOfFocus, int base, Graphics graphics) {
        int height = (int) (base * Math.sqrt(3)/2);

        int[] xPoints = {xOfFocus - base, xOfFocus - base / 2, xOfFocus + base / 2, xOfFocus + base, xOfFocus + base / 2, xOfFocus - base / 2};
        int[] yPoints = {yOfFocus, yOfFocus - height, yOfFocus - height, yOfFocus, yOfFocus + height, yOfFocus + height};

        graphics.drawPolygon(xPoints, yPoints, 6);
    }

    public void drawHexagonFractal (int xOfFocus, int yOfFocus, int base, int level, Graphics graphics) {
        int height = (int) (base * Math.sqrt(3)/2);

        if (level > 0) {

            drawHexagon(xOfFocus, yOfFocus, base, graphics);

            drawHexagonFractal(xOfFocus - base + base / 3, yOfFocus, base / 3, level - 1, graphics);
            drawHexagonFractal(xOfFocus - base / 2 + base / 6, yOfFocus - height + height / 3, base / 3, level - 1, graphics);
            drawHexagonFractal(xOfFocus + base / 2 - base / 6, yOfFocus - height + height / 3, base / 3, level - 1, graphics);
            drawHexagonFractal(xOfFocus + base - base / 3, yOfFocus, base / 3, level - 1, graphics);
            drawHexagonFractal(xOfFocus + base / 2 - base / 6, yOfFocus + height - height / 3, base / 3, level - 1, graphics);
            drawHexagonFractal(xOfFocus - base / 2 + base / 6, yOfFocus + height - height / 3, base / 3, level - 1, graphics);


        }


    }
}
