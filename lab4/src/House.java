import javax.swing.*;
import java.awt.*;

public class House extends  JPanel{
    private JPanel myPanel;
    private JTextField input;
    private JButton getResult;
    private int myX,myY;

    private int mySize = 100;

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(myX + mySize - 20, myY - 60, 20,50);
        g.setColor(Color.RED);
        g.fillRect(myX,myY,mySize,mySize);
        Polygon triangle = new Polygon();
        g.setColor(Color.BLUE);
        triangle.addPoint(myX - 10,myY);
        triangle.addPoint(myX - 10 + mySize / 2, myY - mySize);
        triangle.addPoint(myX + mySize + 10, myY);
        g.fillPolygon(triangle);
    }

    public int getMySize() {
        return mySize;
    }

    public void setSize(int size) {
        if(size >= 0)
            this.mySize = size;
    }

    public int getMyX() {
        return myX;
    }

    public void setMyX(int x) {
        if(x >= mySize)
            this.myX = x;
    }

    public int getMyY() {
        return myY;
    }

    public void setMyY(int y) {
        if(y >= mySize)
            this.myY = y;
    }

    public JTextField getInput() {
        return input;
    }


    public JButton getGetResult() {
        return getResult;
    }
}
