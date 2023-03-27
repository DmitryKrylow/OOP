import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lab6 extends JPanel {
    JPanel myPanel;
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int x = 0;
        int y = 0;
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++) {
                switch (matrix.get(i).get(j)) {
                    case 0:
                        g.setColor(Color.BLACK);
                        break;
                    case 1:
                        g.setColor(Color.YELLOW);
                        break;
                    case 2:
                        g.setColor(Color.BLUE);
                        break;
                    case 3:
                        g.setColor(Color.CYAN);
                        break;
                    case 4:
                        g.setColor(Color.DARK_GRAY);
                        break;
                    case 5:
                        g.setColor(Color.GRAY);
                        break;
                    case 6:
                        g.setColor(Color.GREEN);
                        break;
                    case 7:
                        g.setColor(Color.LIGHT_GRAY);
                        break;
                    case 8:
                        g.setColor(Color.MAGENTA);
                        break;
                    case 9:
                        g.setColor(Color.PINK);
                        break;
                    default:
                        g.setColor(Color.RED);
                        break;
                }
                g.fillRect(x + 50 * j, y + 50 * i,50,50);
            }
        }
    }
    public void paintWait(){
        for(int i = 3; i >= 0; i--){
            Lab6.super.getGraphics().drawString(i + "секунд(ы) до смены",500,500);
            try {
                Thread.sleep(1000);
                Lab6.super.getGraphics().clearRect(450,450,200,200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }

}
