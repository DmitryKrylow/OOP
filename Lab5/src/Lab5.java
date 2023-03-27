import javax.swing.*;
import java.awt.*;

public class Lab5 extends JPanel {

    int size = 50;
    int size5 = 100;
    int startX = 500;
    int startY = 500;

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        drawStar4(startX,startY, g,5);
    }
    private void drawStar5(int startX, int startY, Graphics g, int depth){
        int tX = startX,tY = startY;
        if(depth < 0)
            return;
        g.drawLine(startX,startY, startX += size5 / 2, startY -= size5); // верхний
        g.drawLine(startX,startY, startX += size5 / 2, startY += size5); // правый нижний
        g.drawLine(startX,startY, startX -= size5, startY -= size5 / 2); // левый
        g.drawLine(startX,startY, startX += size5, startY); // правый
        g.drawLine(startX,startY, startX -= size5, startY += size5 / 2); // левый нижний

        drawStar4(tX,tY,g,--depth); // нижний левый
        drawStar4(tX += size5 / 2, tY -= size5,g,depth- 1);
        drawStar4(tX += size5 / 2 , tY += size5, g, depth - 1);
        drawStar4(tX -= size5,tY -= size5 / 2,g,depth- 1);
        drawStar4(tX += size5, tY, g,depth - 1);
    }
    private void drawStar4(int startX, int startY, Graphics g, int depth){
        int tX = startX, tY = startY;
        if(depth < 0)
            return;
        g.drawLine(startX += size, startY, startX -= (size * 2) / 3, startY -= size / 3);//правый угол
        g.drawLine(startX,startY, startX -= size / 3, startY -= (size * 2) / 3);
        g.drawLine(startX,startY, startX -= size / 3,startY += (size * 2) / 3); // верхний угол
        g.drawLine(startX,startY, startX -= (size * 2) / 3, startY += size / 3);
        g.drawLine(startX,startY, startX += size * 2  / 3, startY += size / 3); // левый угол
        g.drawLine(startX,startY, startX += size / 3, startY += size * 2 / 3);
        g.drawLine(startX, startY, startX += size / 3, startY -= size * 2 / 3);//нижний угол
        g.drawLine(startX,startY, startX += size * 2 / 3, startY -= size / 3);

        drawStar5(tX + size, startY, g,depth- 1);
        drawStar5(tX, tY - size,g,depth- 1);
        drawStar5(tX - size, tY, g, depth- 1);
        drawStar5(tX,tY + size,g,depth- 1);
    }
}
