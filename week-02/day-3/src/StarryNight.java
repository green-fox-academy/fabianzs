import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
    public static void mainDraw(Graphics graphics) {
        // Draw the night sky:
        //  - The background should be black
        //  - The stars can be small squares
        //  - The stars should have random positions on the canvas
        //  - The stars should have random color (some shade of grey)

        graphics.setColor(new Color(20,20,20));
        graphics.fillRect(0,0,WIDTH,HEIGHT);

        int x;
        int y;
        int size;


        //Random stars
        for (int i = 0; i < 2000 ; i++) {
            x = (int) (Math.random() * WIDTH);
            y = (int) (Math.random() * HEIGHT);
            size = (int) (Math.random() * 3);

            drawStars(x, y, size, graphics);
        }

        //Stars for the belt
        for (int i = 0; i < 600 ; i++) {
            x = 250 + (int) (Math.random() * 150);
            y = (int) (Math.random() * HEIGHT);
            size = (int) (Math.random() * 3);

            drawLightStars(x, y, size, graphics);
        }


        //Deathstar
        graphics.setColor(Color.GRAY);
        graphics.fillOval(800,150,200,200);

        //Deathstar shadow
        graphics.setColor(new Color(20,20,20, 70));
        graphics.fillOval(743,150,200,200);

        //Smaller circle
        graphics.setColor(new Color(110,110,110));
        graphics.fillOval(920,205,40,40);

        //Shadow for the smaller circle
        graphics.setColor(new Color(20,20,20,80));
        graphics.fillArc(932,208,28,35,270,180);

        //Shadow for the smaller circle
        graphics.setColor(new Color(20,20,20,90));
        graphics.fillArc(935,209,22,33,90,180);

        //Smallest circle
        graphics.setColor(new Color(95,95,95));
        graphics.fillOval(935,220,10,10);

        //Line in the middle
        graphics.setColor(new Color(30,30,30, 80));
        graphics.drawLine(800,260, 1000, 260 );
        graphics.drawLine(800,259, 1000, 259 );
        graphics.drawLine(800,258, 1000, 258 );









    }

    // Don't touch the code below
    static int WIDTH = 1200;
    static int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }

    public static void drawStars (int x, int y, int size, Graphics graphics) {
        int c = (int) (Math.random() * 255);
        graphics.setColor(new Color(c, c, c));
        graphics.fillRect(x, y, size, size);
    }

    public static void drawLightStars (int x, int y, int size, Graphics graphics) {
        int c = (int) (80 + (Math.random() * 134));
        graphics.setColor(new Color(c, c, c));
        graphics.fillRect(x, y, size, size);
    }
}
