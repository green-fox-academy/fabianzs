package fractals;

import java.awt.*;
import java.util.Random;

public class SquareGrid {
    int size;
    float stroke;

    public SquareGrid(int size, float stroke) {
        this.size = size;
        this.stroke = stroke;
    }

    public void drawSquareGrid(int startX, int startY, int size, float stroke, int level, Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(stroke));

        Color randomColor = new Color(new Random().nextInt(255),new Random().nextInt(255), new Random().nextInt(255));
        graphics.setColor(randomColor);

        g2.drawRect(startX, startY, size, size);

        if (level > 0) {
            drawSquareGrid(startX - size / 4, startY - size / 4, size / 2, stroke / 2, level - 1, graphics);
            drawSquareGrid(startX + 3 * size / 4, startY - size / 4, size / 2, stroke / 2, level - 1, graphics);
            drawSquareGrid(startX + 3 * size / 4, startY + 3 * size / 4, size / 2, stroke / 2, level - 1, graphics);
            drawSquareGrid(startX - size / 4, startY + 3 * size / 4, size / 2, stroke / 2, level - 1, graphics);
        }


    }

}
