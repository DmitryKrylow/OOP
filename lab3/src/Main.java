import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args) {
        //Setup frame
        JFrame frame = new JFrame();
        Lab3 window = new Lab3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((int) (dim.getWidth() / 2 - 250), (int) (dim.getHeight() / 2 - 250),500,500);
        frame.setTitle("Krylov Lab 3");
        frame.setContentPane(window.getPanel());
        frame.setVisible(true);
        window.getOutPaneA().setEditable(false);
        window.getOutPaneB().setEditable(false);
        //set ActionListener on button in window
        window.getGetResult().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if we get exception then input ha a wrong format
                try {
                    window.getOutPaneA().setText(TaskA.print(Integer.parseInt(window.getInputField().getText())));
                    window.getOutPaneB().setText(TaskB.print(Integer.parseInt(window.getInputField().getText())));
                }catch (NumberFormatException exception){
                    window.getOutPaneA().setText("Вы ввели не число!");
                    exception.printStackTrace();
                }
            }
        });
    }
}