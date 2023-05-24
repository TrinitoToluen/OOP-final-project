package forms;

import java.util.Map;

import javax.swing.*;

public class FilerPatientAgeForm extends Form {
    private JPanel mainPanel;

    private JTextField txtGreater;
    private JTextField txtLess;
    private JTextField txtEqual;
    private JButton btnFilter;

    public FilerPatientAgeForm(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        txtGreater = new JTextField(20);
        txtLess = new JTextField(20);
        txtEqual = new JTextField(20);
        btnFilter = new JButton("Filter");

        mainPanel.add(new JLabel("Greater than"));
        mainPanel.add(txtGreater);
        mainPanel.add(new JLabel("Less than"));
        mainPanel.add(txtLess);
        mainPanel.add(new JLabel("Equal to"));
        mainPanel.add(txtEqual);
        mainPanel.add(btnFilter);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = new java.util.HashMap<>();
        data.put("greater", txtGreater.getText());
        data.put("less", txtLess.getText());
        data.put("equal", txtEqual.getText());

        return data;
    }

    @Override
    public JButton getBtnSubmit() {
        return btnFilter;
    }
    
}
