import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Main {
    private static final JFrame window = new JFrame();
    private static final Lab11 panel = new Lab11();
    private static final LinkedList<Person> persons = new LinkedList<>();
    public static void main(String[] args) {
        init();
        displayAllPerson();
    }
    public static void init(){
        window.setSize(700,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setActionListener();
        setFocusListener();

        window.add(panel.getMainPanel());
        window.setVisible(true);
    }
    private static void setActionListener(){
        panel.getBtnDisplayAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllPerson();
            }
        });
        panel.getBtnResult().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPersons();
            }
        });
        panel.getDeleteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    persons.delete(persons.findBySurname(panel.getFindBySurname().getText()));
                    displayAllPerson();
                }catch (NullPointerException exception){
                    exception.printStackTrace();
                    displayError(exception);
                }
            }
        });
        panel.getAddUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = panel.getInputName().getText().matches("Введите имя") ? "" : panel.getInputName().getText();
                String surname = panel.getInputSurname().getText().matches("Введите фамилию") ? "" : panel.getInputSurname().getText();
                String lastname = panel.getInputLastName().getText().matches("Введите отчество") ? "" : panel.getInputLastName().getText();
                String phoneNumber = panel.getInputPhoneNumber().getText().matches("Введите номер телефона") ? "" : panel.getInputPhoneNumber().getText();
                if(name.equals("") || surname.equals("") || lastname.equals("") || phoneNumber.equals("")){
                    return;
                }
                persons.add(new Person(name,surname,lastname,phoneNumber));
                displayAllPerson();
            }
        });
    }
    private static void setFocusListener(){
        panel.getInputPhoneNumber().setMargin(new Insets(8,8,8,8));
        panel.getInputSurname().setMargin(new Insets(8,8,8,8));
        panel.getInputLastName().setMargin(new Insets(8,8,8,8));
        panel.getInputName().setMargin(new Insets(8,8,8,8));
        panel.getFindBySurname().setMargin(new Insets(8,8,8,8));
        panel.getFindByName().setMargin(new Insets(8,8,8,8));


        panel.getInputName().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                panel.getInputName().setText(panel.getInputName().getText().equals("Введите имя") ? "" : panel.getInputName().getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                panel.getInputName().setText(panel.getInputName().getText().equals("") ? "Введите имя" : panel.getInputName().getText());
            }
        });

        panel.getInputSurname().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                panel.getInputSurname().setText(panel.getInputSurname().getText().equals("Введите фамилию") ? "" : panel.getInputSurname().getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                panel.getInputSurname().setText(panel.getInputSurname().getText().equals("") ? "Введите фамилию" : panel.getInputSurname().getText());
            }
        });

        panel.getInputLastName().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                panel.getInputLastName().setText(panel.getInputLastName().getText().equals("Введите отчество") ? "" : panel.getInputLastName().getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                panel.getInputLastName().setText(panel.getInputLastName().getText().equals("") ? "Введите отчество" : panel.getInputLastName().getText());
            }
        });

        panel.getInputPhoneNumber().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                panel.getInputPhoneNumber().setText(panel.getInputPhoneNumber().getText().equals("Введите номер телефона") ? "" : panel.getInputPhoneNumber().getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                panel.getInputPhoneNumber().setText(panel.getInputPhoneNumber().getText().equals("") ? "Введите номер телефона" : panel.getInputPhoneNumber().getText());
            }
        });

        panel.getFindByName().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                panel.getFindByName().setText(panel.getFindByName().getText().equals("Введите имя") ? "" : panel.getFindByName().getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                panel.getFindByName().setText(panel.getFindByName().getText().equals("") ? "Введите имя" : panel.getFindByName().getText());
            }
        });

        panel.getFindBySurname().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                panel.getFindBySurname().setText(panel.getFindBySurname().getText().equals("Введите фамилию") ? "" : panel.getFindBySurname().getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                panel.getFindBySurname().setText(panel.getFindBySurname().getText().equals("") ? "Введите фамилию" : panel.getFindBySurname().getText());
            }
        });

    }
    public static void displayError(NullPointerException e){
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("В базе данных нет элементов!");
        panel.getScrollPanel().getViewport().add(textArea);
    }
    private static void displayAllPerson(){
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        if(!persons.isEmpty()){
            String s = persons.toString(panel.getReverse().isSelected());
            textArea.setText(s.isEmpty() || s.equals("null") ? "В базе данных нет ни одного пользователя!" : s);
        }else{
            textArea.setText("В базе данных нет ни одного пользователя!");
        }
        panel.getScrollPanel().getViewport().add(textArea);
    }
    private static void displayPersons(){
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        if(!persons.isEmpty()){
            String s = persons.findByName(panel.getFindByName().getText().equals("Введите имя") ? "" : panel.getFindByName().getText()).toString(panel.getReverse().isSelected());
            textArea.setText(s.isEmpty() || s.equals("null") ? "Нет пользователя с таким именем!" : s);
        }else{
            textArea.setText("В базе данных нет ни одного пользователя!");
        }
        panel.getScrollPanel().getViewport().add(textArea);
    }
}