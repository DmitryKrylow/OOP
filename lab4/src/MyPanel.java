import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
    private JPanel myJPanel;

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        int countLines = 30;
        int size = 20;
        int x1 = 10;
        int y1 = 20;
        int x2 = 10;
        int y2 = y1 * countLines;
        g.drawLine(x1, y1, x2, y2);
        for(int i = 0; y2 != y1; i++){
            x2 += size;
            y1 += size;
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
