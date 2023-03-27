import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final JFrame window = new JFrame();
    private static final GUI content = new GUI();
    private static final int SCREE_SIZE = 500;
    private static File file;
    private static ArrayList<String[]> arrayList;
    private static final JTextArea txt = new JTextArea();
    public static void main(String[] args) {
        init();
    }
    public static void init(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setBounds(dim.width / 2 - SCREE_SIZE, dim.height / 2 - SCREE_SIZE, SCREE_SIZE,SCREE_SIZE);
        content.getTextOutput().createVerticalScrollBar();
        file = new File("input.txt");
        StringBuilder str = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                str.append(scanner.nextLine()).append("\n");
            }
            txt.setText(str.toString());
            txt.setEditable(false);
            content.getTextOutput().getViewport().add(txt);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        content.getBtnTaskA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //math for A [(A)]{2}
                //math for B (.)\\1
                //math for split \n or " " [\\n|\\s]
                arrayList = new ArrayList<>();
                for(int i = 0; i < str.toString().split("\n").length;i++){
                    arrayList.add(str.toString().split("\n")[i].split(" "));
                }
                taskA();
                display();
            }
        });
        content.getBtnTaskB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //math for A [(A)]{2}
                //math for B (.)\\1
                //math for split \n or " " [\\n|\\s]
                arrayList = new ArrayList<>();
                for(int i = 0; i < str.toString().split("\n").length;i++){
                    arrayList.add(str.toString().split("\n")[i].split(" "));
                }
                taskB();
                display();
            }
        });
        content.getBtnTaskC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //math for A [(A)]{2}
                //math for B (.)\\1
                //math for split \n or " " [\\n|\\s]
                arrayList = new ArrayList<>();
                for(int i = 0; i < str.toString().split("\n").length;i++){
                    arrayList.add(str.toString().split("\n")[i].split(" "));
                }
                taskC();
                display();
            }
        });
        content.getBtnTaskD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //math for A [(A)]{2}
                //math for B (.)\\1
                //math for split \n or " " [\\n|\\s]
                arrayList = new ArrayList<>();
                for(int i = 0; i < str.toString().split("\n").length;i++){
                    arrayList.add(str.toString().split("\n")[i].split(" "));
                }
                taskD();
                display();
            }
        });
        window.add(content.getPanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    public static void display(){
        String out = "";
        for(var el : arrayList){
            boolean flag = true;
            for(String st : el){
                if(st.equals("")) {
                    flag = false;
                    continue;
                }
                out += st + " ";
            }
            if(flag)
                out += "\n";
        }
        txt.setText(out);
        txt.setEditable(false);
        content.getTextOutput().getViewport().add(txt);
        try {
            PrintWriter printWriter = new PrintWriter("output.txt");
            printWriter.print(txt.getText());
            printWriter.flush();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void taskA(){
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = 0; j < arrayList.get(i).length; j++){
                arrayList.get(i)[j] = arrayList.get(i)[j].replaceAll("[(A)]{2}","*");
            }
        }
    }
    public static void taskB(){
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = 0; j < arrayList.get(i).length; j++){
                arrayList.get(i)[j] = arrayList.get(i)[j].replaceAll("(.)\\1","*");
            }
        }
    }
    public static void taskC(){
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = 0; j < arrayList.get(i).length; j++){
                if(arrayList.get(i)[j].toLowerCase().contains("a")){
                    arrayList.get(i)[j] = "";
                }
            }
        }
    }
    public static void taskD(){
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = 0; j < arrayList.get(i).length; j++){
                if((arrayList.get(i)[j].contains("a") || arrayList.get(i)[j].contains("A") || arrayList.get(i)[j].contains("А") || arrayList.get(i)[j].contains("а"))){
                    arrayList.get(i)[j] = "<" + arrayList.get(i)[j] + ">";
                }
            }
        }
    }
}
