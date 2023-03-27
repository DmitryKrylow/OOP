import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    private static File file;
    private static int n, m;
    private static ArrayList<ArrayList<Integer>> matrix;
    public static void main(String[] args) {
        inputArray();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lab6 panel = new Lab6();
        panel.setMatrix(matrix);
        frame.add(panel);
        frame.setSize(1000,1000);
        frame.setVisible(true);
        panel.paintWait();
        taskB();
        panel.setMatrix(matrix);
        panel.repaint();
    }
    public static void inputArray(){
        try {
            file = new File("./input.txt");
            Scanner scanner = new Scanner(file);
            matrix = new ArrayList<>();
            n = scanner.nextInt();
            m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                matrix.add(new ArrayList<>());
                for (int j = 0; j < m; j++) {
                    matrix.get(i).add(scanner.nextInt());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void taskA(){
        for(int i = 0; i < m; i++){
            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(matrix.get(j).get(i) % 2 != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int j = 0; j < n; j++){
                    matrix.get(j).set(i,matrix.get(j).get(i) * 10);
                }
            }
        }
    }
    public static void taskB(){
        for(int i = 0; i < matrix.size(); i++){
            boolean flag = true;
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(sumOfNumber(String.valueOf(abs(matrix.get(i).get(j)))) >= 5){
                    flag = false;
                    break;
                }
            }
            if(flag){
                matrix.remove(matrix.get(i));
                i--;
            }
        }
    }
    public static int sumOfNumber(String number){
        int res = 0;
        for(char c : number.toCharArray()){
            res += c - '0';
        }
        return res;
    }
}