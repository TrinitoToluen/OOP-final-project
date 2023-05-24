package forms;

import javax.swing.*;
import java.util.Map;

public abstract class Form extends JDialog{

    abstract public Map<String, String> getData();

    abstract public JButton getBtnSubmit();

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
