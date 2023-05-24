package forms;

import javax.swing.*;
import java.util.Map;

public class AddPatientForm extends Form {
    private JPanel mainPanel;

    private JTextField txtName;
    private JTextField txtGender;
    private JTextField txtAge;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtAddress;
    private JButton btnAddPatient;

    public AddPatientForm(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        txtName = new JTextField(20);
        txtGender = new JTextField(20);
        txtAge = new JTextField(20);
        txtEmail = new JTextField(20);
        txtPhone = new JTextField(20);
        txtAddress = new JTextField(20);
        btnAddPatient = new JButton("Add Patient");

        mainPanel.add(new JLabel("Name"));
        mainPanel.add(txtName);
        mainPanel.add(new JLabel("Gender"));
        mainPanel.add(txtGender);
        mainPanel.add(new JLabel("Age"));
        mainPanel.add(txtAge);
        mainPanel.add(new JLabel("Email"));
        mainPanel.add(txtEmail);
        mainPanel.add(new JLabel("Phone"));
        mainPanel.add(txtPhone);
        mainPanel.add(new JLabel("Address"));
        mainPanel.add(txtAddress);
        mainPanel.add(btnAddPatient);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public Map<String, String> getData(){
        Map<String, String> data = new java.util.HashMap<>();
        data.put("name", txtName.getText());
        data.put("gender", txtGender.getText());
        data.put("age", txtAge.getText());
        data.put("email", txtEmail.getText());
        data.put("phone", txtPhone.getText());
        data.put("address", txtAddress.getText());

        return data;
    }

    public JButton getBtnSubmit() {
        return btnAddPatient;
    }
}
