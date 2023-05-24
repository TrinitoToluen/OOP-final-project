package forms;

import java.util.Map;

import javax.swing.*;

public class DeleteRoomForm extends Form {
    private JPanel mainPanel;

    private JTextField txtId;
    private JTextField txtName;
    private JButton btnDelRoom;

    public DeleteRoomForm(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        txtId = new JTextField(20);
        txtName = new JTextField(20);
        btnDelRoom = new JButton("Delete Room");

        mainPanel.add(new JLabel("ID"));
        mainPanel.add(txtId);
        mainPanel.add(new JLabel("Name"));
        mainPanel.add(txtName);
        mainPanel.add(btnDelRoom);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = new java.util.HashMap<>();
        data.put("id", txtId.getText());
        data.put("name", txtName.getText());

        return data;
    }

    @Override
    public JButton getBtnSubmit() {
        return btnDelRoom;
    }

}
