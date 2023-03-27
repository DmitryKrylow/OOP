import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Lab7 extends JPanel {
    private JPanel myPane;

    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

    @Override
    public void paint(Graphics g){
        super.paint(g);
        int x = 0;
        int y = 0;
        try {
            BufferedImage rock = ImageIO.read(new File("rock_res.png"));
            BufferedImage earth = ImageIO.read(new File("earth_res.jpeg"));
            BufferedImage steve = ImageIO.read(new File("steve.png"));
            BufferedImage diamond = ImageIO.read(new File("diamond.png"));

            for(int i = 0; i < matrix.size(); i++){
                for(int j = 0; j < matrix.get(i).size(); j++) {
                    switch (matrix.get(i).get(j)) {
                        case 0:
                            g.drawImage(rock,x + 64 * j, y + 64 * i, null);
                            break;
                        case 1:
                            g.drawImage(earth, x + 64 * j, y + 64 * i, null);
                            break;
                        case 3:
                            g.drawImage(earth, x + 64 * j, y + 64 * i, null);
                            g.drawImage(steve,x+64*j,y+64 *i,null);
                            break;
                        case 4:
                            g.drawImage(earth, x + 64 * j, y + 64 * i, null);
                            g.drawImage(diamond,x+64*j,y+64 *i,null);
                            break;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }
}
