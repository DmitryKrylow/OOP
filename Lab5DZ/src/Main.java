import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static JFrame frame;
    private static final boolean VISIBLE = true;
    public static void main(String[] args) {
        frame = new JFrame("Lab 5 DZ Krylov");
        Func gui = new Func();
        gui.getOutPane().setText("Введите в первой строке точность вычислений, во второй число в диапазоне [-1;1]");
        frame.add(gui.getJpanel());
        int screenSize = 500;
        frame.setBounds(((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - screenSize / 2)), ((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - screenSize / 2)), screenSize,screenSize);
        frame.setVisible(VISIBLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getResultBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Double.parseDouble(gui.getInputField().getText()) <= 1 && Double.parseDouble(gui.getInputField().getText()) >= -1) {
                        gui.getOutPane().setText(String.valueOf(gui.calculate(Double.parseDouble(gui.getInputField().getText()), Integer.parseInt(gui.getInputAccuracy().getText()), 1)));
                    } else {
                        gui.getOutPane().setText("Wrong input. X range [-1;1]");
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                    gui.getOutPane().setText("Введите число в формате 0.xxxx");
                }
            }
        });
    }

}