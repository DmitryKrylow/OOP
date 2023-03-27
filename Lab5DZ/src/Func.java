import javax.swing.*;

public class Func {
    private JTextField inputField;
    private JButton resultBtn;
    private JTextPane outPane;

    public JPanel getJpanel() {
        return jpanel;
    }

    private JPanel jpanel;
    private JTextField inputAccuracy;

    public double calculate(double x, int accuracy,int m){
        if(m >= accuracy){
            return (Math.pow(x,2 * m - 1)) / (2 * m - 1);
        }
        return 2 * (Math.pow(x,2 * m - 1)) / (2 * m - 1) + calculate(x,accuracy,++m);
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JButton getResultBtn() {
        return resultBtn;
    }

    public JTextPane getOutPane() {
        return outPane;
    }

    public JTextField getInputAccuracy() {
        return inputAccuracy;
    }
}
