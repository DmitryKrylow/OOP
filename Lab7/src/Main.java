import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static File file;
    private static int PLAYER = 3;
    private static int ROCK = 0;
    private static int DIAMOND = 4;
    private static int typeEl = 0;
    private static int playerPos = 0;
    private static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    public static void main(String[] args) {
        inputArray();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lab7 window = new Lab7();
        frame.setSize(1000,1000);
        window.setMatrix(matrix);
        frame.add(window);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                    if(changePosition(e))
                        frame.repaint();
            }
        });
        frame.setVisible(true);

    }
    public static boolean changePosition(KeyEvent event) {
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).contains(PLAYER)) {
                playerPos = matrix.get(i).indexOf(PLAYER);
                switch (event.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (playerPos - 1 < 0) {
                            return false;
                        }
                        typeEl = matrix.get(i).get(playerPos - 1);
                        if (typeEl == ROCK) {
                            return false;
                        } else {
                            matrix.get(i).set(playerPos, typeEl);
                            matrix.get(i).set(playerPos - 1, PLAYER);
                            return true;
                        }
                    case KeyEvent.VK_RIGHT:
                        if(playerPos + 1 >= matrix.size()){
                            return false;
                        }
                        typeEl = matrix.get(i).get(playerPos + 1);
                        if(typeEl == ROCK){
                            return false;
                        }else{
                            matrix.get(i).set(playerPos, typeEl);
                            matrix.get(i).set(playerPos + 1, PLAYER);
                            return true;
                        }
                    case KeyEvent.VK_DOWN:
                        if(i + 1 >= matrix.size()){
                            return false;
                        }
                        typeEl = matrix.get(i + 1).get(playerPos);
                        if(typeEl == ROCK){
                            return false;
                        }else{
                            matrix.get(i).set(playerPos,typeEl);
                            matrix.get(i+1).set(playerPos,PLAYER);
                            return true;
                        }
                    case KeyEvent.VK_UP:
                        if(i - 1 < 0){
                            return false;
                        }
                        typeEl = matrix.get(i - 1).get(playerPos);
                        if(typeEl == ROCK){
                            return false;
                        }else{
                            matrix.get(i).set(playerPos,typeEl);
                            matrix.get(i-1).set(playerPos,PLAYER);
                            return true;
                        }
                }
                System.out.println(matrix);
                break;
            }
        }
        return false;
    }
    public static void inputArray(){
        try {
            file = new File("./input.txt");
            Scanner scanner = new Scanner(file);
            matrix = new ArrayList<>();
            for (int i = 0;scanner.hasNext(); i++) {
                matrix.add(new ArrayList<>());
                String str = scanner.next();
                for (char c : str.toCharArray()) {
                    matrix.get(i).add(c - '0');
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}