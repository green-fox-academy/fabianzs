import javax.swing.*;

public class DrawingGraphicBasicRun {
    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingGraphicsBasic p = new DrawingGraphicsBasic();
        f.add(p);
        f.setSize(400, 250);
        f.setVisible(true);
    }
}
