import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class MainForm {

    private JPanel mainPanel;
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField patronymicField;
    private JButton button;

    public MainForm() {
        createGUI();
    }

    public void createGUI() {
        button.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = button.getText();
                if (Objects.equals(buttonText, "Collapse")) {
                    showOneRow();
                } else {
                    showThreeRow();
                }

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void showOneRow() {
        String surname = surnameField.getText();
        String name = nameField.getText();
        String patronymic = patronymicField.getText();
        if (surname.isBlank() || name.isBlank()) {
           errMessage();
        } else {
            button.setText("Expand");
            nameField.setVisible(false);
            nameField.setText("");
            patronymicField.setVisible(false);
            patronymicField.setText("");
            surnameField.setText(surname + " " + name + " " + patronymic);
        }

    }

    private void showThreeRow(){
        button.setText("Collapse");
        String[] splitText = surnameField.getText().split(" ");
        if (splitText.length >= 2) {
            surnameField.setText(splitText[0]);
            nameField.setText(splitText[1]);
            nameField.setVisible(true);
            if (splitText.length == 3) {
                patronymicField.setText(splitText[2]);
            }
            patronymicField.setVisible(true);
        } else {
            errMessage();
        }
    }

    private void errMessage () {
        JOptionPane.showMessageDialog(
                mainPanel,
                "Пожайлуйста, введите данные!",
                "Ошибка",
                JOptionPane.ERROR_MESSAGE);
    }
}
