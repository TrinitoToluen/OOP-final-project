package forms;

import java.util.Map;

import javax.swing.*;

public class AddRoomForm extends Form{
    private JPanel mainPanel;

    private JTextField txtName;
    private JButton btnAddRoom;

    public AddRoomForm(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        txtName = new JTextField(20);
        btnAddRoom = new JButton("Add Room");

        mainPanel.add(new JLabel("Name"));
        mainPanel.add(txtName);
        mainPanel.add(btnAddRoom);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = new java.util.HashMap<>();
        data.put("name", txtName.getText());

        return data;
    }

    @Override
    public JButton getBtnSubmit() {
        return btnAddRoom;
    }
}
