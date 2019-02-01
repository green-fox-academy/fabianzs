package fractals;

import java.awt.*;
import java.util.Random;

public class Circle {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void drawCircle(int startX, int startY, int radius, Graphics graphics) {
        Color randomColor = new Color(new Random().nextInt(255),new Random().nextInt(255), new Random().nextInt(255));
        graphics.setColor(randomColor);

        graphics.drawOval(startX, startY, 2 * radius, 2 * radius);
    }

    public void drawCircleFractal(int startX, int startY, int radius, int level, Graphics graphics) {
        int cos = (int) (radius * Math.sqrt(3)/2);

        if (level > 0) {

            drawCircle(startX, startY, radius, graphics);

            drawCircleFractal(startX + radius/2, startY, radius/2, level - 1, graphics);
            drawCircleFractal(startX + radius - cos / 2 - radius / 2, startY + radius + radius / 4 - radius / 2, radius/2, level - 1, graphics);
            drawCircleFractal(startX + radius + cos / 2 - radius / 2, startY + radius + radius / 4 - radius / 2, radius/2, level - 1, graphics);
        }
    }

}
