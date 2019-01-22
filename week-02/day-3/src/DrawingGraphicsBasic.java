import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingGraphicsBasic extends JPanel {
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.ORANGE);
        g.fillRect(25,25,100,30);

        g.setColor(new Color(190,81, 215));
        g.fillRect(25,65,100,30);

        g.setColor(Color.GRAY);
        g.drawString("this is some text", 25,120);

        g.setColor(Color.RED);
        g.drawLine(25,130,100, 180);

        g.drawRect(25, 200, 100, 30);

        g.fillOval(25, 250, 100, 30);

        g.fill3DRect(25, 500, 100, 30, true);


    }

}
