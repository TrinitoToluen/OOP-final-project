package forms;

import javax.swing.*;
import java.util.Map;

public class DeletePatientForm extends Form{
    private JPanel mainPanel;
    
    private JTextField txtID;
    private JTextField txtName;
    private JButton btnDeletePatient;

    public DeletePatientForm(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        txtID = new JTextField(20);
        txtName = new JTextField(20);
        btnDeletePatient = new JButton("Delete Patient");

        mainPanel.add(new JLabel("ID"));
        mainPanel.add(txtID);
        mainPanel.add(new JLabel("Name"));
        mainPanel.add(txtName);
        mainPanel.add(btnDeletePatient);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = new java.util.HashMap<>();
        data.put("id", txtID.getText());
        data.put("name", txtName.getText());

        return data;
    }

    @Override
    public JButton getBtnSubmit() {
        return btnDeletePatient;
    }
}
