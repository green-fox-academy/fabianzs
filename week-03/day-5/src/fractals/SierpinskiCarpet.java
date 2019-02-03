package fractals;

import java.awt.*;
import java.util.Random;

public class SierpinskiCarpet {
    int size;

    public SierpinskiCarpet(int size) {
        this.size = size;
    }

    public void drawSierpinskiCarpet(int startX, int startY, int size,int level, Graphics graphics) {
        Color randomColor = new Color(new Random().nextInt(255),new Random().nextInt(255), new Random().nextInt(255));
        graphics.setColor(randomColor);

        graphics.fillRect(startX, startY, size, size);

        if (level > 0) {

            drawSierpinskiCarpet(startX - 2 * size / 3, startY - 2 * size / 3, size/3, level - 1, graphics);
            drawSierpinskiCarpet(startX - 2 * size / 3, startY + size / 3, size/3, level - 1,graphics);
            drawSierpinskiCarpet(startX - 2 * size / 3, startY + 4 * size / 3, size/3,level - 1, graphics);
            drawSierpinskiCarpet(startX + size / 3, startY + 4 * size / 3, size/3, level - 1,graphics);
            drawSierpinskiCarpet(startX + 4 * size / 3, startY + 4 * size / 3, size/3,level - 1, graphics);
            drawSierpinskiCarpet(startX + 4 * size / 3, startY + size / 3, size/3,level - 1, graphics);
            drawSierpinskiCarpet(startX + 4 * size / 3, startY - 2 * size / 3, size/3,level - 1, graphics);
            drawSierpinskiCarpet(startX + size / 3, startY - 2 * size / 3, size/3,level - 1, graphics);

        }



    }
}
