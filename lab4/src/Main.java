import javax.swing.*;
import java.awt.*;

public class Main {
    private static JFrame frame;
    public static void main(String[] args) {
        init();
    }
    public static void init(){
        MyPanel myPanel = new MyPanel();
        frame = new JFrame("Lab 4");
        frame.getContentPane().add(myPanel);
        frame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((int)dim.getWidth() / 2 - 350, (int)dim.getHeight() / 2  - 350, 700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}