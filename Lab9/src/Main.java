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

public class Main {
    private static final JFrame window = new JFrame("Krylov lab 9");
    private static final Lab9 panel = new Lab9();
    private static File file;
    private static String html = "";
    private static int cnt = 0;
    public static void main(String[] args) {
        init();

    }
    private static void init() {
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        panel.getBtnResultA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskA();
            }
        });
        panel.getBtnResultB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskB();
            }
        });
        window.setContentPane(panel.getMainPanel());
    }
    private static void taskA() {
        initHtml("A");
        File file = new File("input.txt");
        Scanner scanner;
        ArrayList<String> strings = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                strings.add(scanner.nextLine());
            }
            for (String el : strings) {
                for (String el1 : el.split(" ")) {
                    if (el1.charAt(0) == 'A' || el1.charAt(0) == 'А') {
                        cnt++;
                    }
                }
            }
            html += String.format("<p>Имя файла: <b>%s</b>", file.getName());
            html += String.format("<p>Количество найденных слов: <b>%d</b>", cnt);
            write();
            initHtml("A");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void taskB() {
        initHtml("B");
        File file = new File("input.txt");
        Scanner scanner;
        ArrayList<String> strings = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                strings.add(scanner.nextLine());
            }
            for (String el : strings) {
                for (String el1 : el.split(" ")) {
                    if (el1.startsWith(panel.getInputText().getText())) {
                        cnt++;
                    }
                }
            }
            html += String.format("<p>Имя файла: <b>%s</b>", file.getName());
            html += String.format("<p>Искомая последовательность: <b>%s</b>", panel.getInputText().getText());
            html += String.format("<p>Количество найденных слов: <b>%d</b></html>", cnt);
            write();
            initHtml("B");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void write() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("output.html");
        pw.write(html);
        pw.flush();

        JEditorPane textArea = new JEditorPane();
        textArea.setContentType("text/html");
        textArea.setText(html);
        textArea.setEditable(false);
        panel.getScrollPanel().getViewport().add(textArea);
    }
    private static void initHtml(String var){
        html = "";
        cnt = 0;
        html += "<html><p align=\"center\"><b>Лабораторная работа №9</b></p>" +
                "<p align=\"center\">Вариант <i>"+var+"</i></p>" +
                "<p>Выполнил студент группы ИВТбд-12 <b>Крылов Д.А</b></p>";
    }
}