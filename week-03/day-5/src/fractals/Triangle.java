package fractals;

import java.awt.*;
import java.util.Random;

public class Triangle {

    int base;
    int level;

    public Triangle(int base) {
        this.base = base;
    }

    public void drawTriangle(int xOfFocus, int yOfFocus, int base, Graphics graphics) {
        Color randomColor = new Color(new Random().nextInt(255),new Random().nextInt(255), new Random().nextInt(255));
        graphics.setColor(randomColor);

        int height = (int) (base * Math.sqrt(3)/2);

        int[] xPoints = {xOfFocus - base/2, xOfFocus + base / 2, xOfFocus};
        int[] yPoints = {yOfFocus - height/3, yOfFocus - height/3, yOfFocus + 2*height/3};

        graphics.drawPolygon(xPoints, yPoints, 3);
    }


    public void drawTriangleFractal(int xOfFocus, int yOfFocus, int base, int level, Graphics graphics) {
        int height = (int) (base * Math.sqrt(3)/2);

        if (level > 0) {

            drawTriangle(xOfFocus, yOfFocus, base, graphics);

            drawTriangleFractal(xOfFocus - base/4, yOfFocus - height/6, base/2, level - 1, graphics);
            drawTriangleFractal(xOfFocus + base/4, yOfFocus - height/6, base/2, level - 1, graphics);
            drawTriangleFractal(xOfFocus, yOfFocus + height/3, base/2, level - 1, graphics);
        }
    }

}
