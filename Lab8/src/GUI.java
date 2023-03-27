import javax.swing.*;

public class GUI extends JPanel{
    private JButton btnTaskA;
    private JScrollPane textOutput;
    private JPanel panel;
    private JButton btnTaskB;
    private JButton btnTaskC;
    private JButton btnTaskD;

    public JPanel getPanel() {
        return panel;
    }

    public JButton getBtnTaskA() {
        return btnTaskA;
    }

    public JButton getBtnTaskB() {
        return btnTaskB;
    }

    public JButton getBtnTaskC() {
        return btnTaskC;
    }

    public JButton getBtnTaskD() {
        return btnTaskD;
    }

    public JScrollPane getTextOutput() {
        return textOutput;
    }
}
