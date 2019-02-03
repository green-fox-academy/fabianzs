package fractals;

import java.awt.*;

public class Triangle {
    int base;

    public Triangle(int base) {
        this.base = base;
    }

    public static void drawTriangle(int xOfFocus, int yOfFocus, int base, Graphics graphics) {
        //Color randomColor = new Color(new Random().nextInt(255),new Random().nextInt(255), new Random().nextInt(255));
        //graphics.setColor(randomColor);

        int height = (int) (base * Math.sqrt(3)/2);

        int[] xPoints = {xOfFocus - base/2, xOfFocus + base / 2, xOfFocus};
        int[] yPoints = {yOfFocus - height/3, yOfFocus - height/3, yOfFocus + 2 * height/3};

        graphics.drawPolygon(xPoints, yPoints, 3);
    }

    public static void fillTriangleDown(int xOfFocus, int yOfFocus, int base, Graphics graphics) {

        int height = (int) (base * Math.sqrt(3)/2);

        int[] xPoints = {xOfFocus - base/2, xOfFocus + base / 2, xOfFocus};
        int[] yPoints = {yOfFocus - height/3, yOfFocus - height/3, yOfFocus + 2 * height/3};

        graphics.fillPolygon(xPoints, yPoints, 3);
    }

    public static void fillTriangleUp(int xOfFocus, int yOfFocus, int base, Graphics graphics) {

        int height = (int) (base * Math.sqrt(3)/2);

        int[] xPoints = {xOfFocus - base/2, xOfFocus + base / 2, xOfFocus};
        int[] yPoints = {yOfFocus + height/3, yOfFocus + height/3, yOfFocus - 2 * height/3};

        graphics.fillPolygon(xPoints, yPoints, 3);
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

    public static int[][] calculateTriangleCoordinates(int xOfFocus, int yOfFocus, int base) {
        int height = (int) (base * Math.sqrt(3)/2);

        int[][] triangleCoordinates =   {{xOfFocus - base / 2, yOfFocus - height / 3},
                                        {xOfFocus + base / 2, yOfFocus - height / 3},
                                        {xOfFocus, yOfFocus + 2 * height / 3}};

        return triangleCoordinates;

    }

}
