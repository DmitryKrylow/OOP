import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final JFrame window = new JFrame("Krylov lab 10");
    private static final Lab10 panel = new Lab10();
    public static void main(String[] args) {
        init();
    }
    public static void init(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,500);
        window.setContentPane(panel.getMainPanel());
        window.setVisible(true);
        panel.getBtnResult().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] mas = panel.getEnterText().getText().split(" ");

                try{
                    Integer[] array = new Integer[mas.length];
                    for(int i = 0; i < array.length; i++){
                        array[i] = Integer.parseInt(mas[i].toString());
                    }
                    Algorithm.quickSort(array,0, mas.length-1);
                    mas = array;
                }catch (NumberFormatException exception){
                    Algorithm.quickSort(((String[]) mas),0, mas.length-1);
                }
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false);
                textArea.setText(Algorithm.buildString() + "\nEnd of sort: " + Arrays.toString(mas));
                panel.getScrollPanel().getViewport().add(textArea);
                try {
                    PrintWriter pw = new PrintWriter(new File("output.txt"));
                    pw.write(Arrays.toString(mas));
                    pw.flush();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}