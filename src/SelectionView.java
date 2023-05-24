import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class SelectionView extends JPanel {
    private JButton btnPatient;
    private JButton btnRoom;
    private JButton btnSave;
    private JButton btnWipe;

    public SelectionView() {
        btnPatient = new JButton("Manage Patients");
        btnPatient.setFont(new Font("Arial", Font.BOLD, 32));
        btnRoom = new JButton("Manage Treatment Rooms");
        btnRoom.setFont(new Font("Arial", Font.BOLD, 32));
        btnSave = new JButton("Save data");
        btnSave.setFont(new Font("Arial", Font.BOLD, 32));
        btnWipe = new JButton("Wipe data");
        btnWipe.setFont(new Font("Arial", Font.BOLD, 32));
        btnWipe.setForeground(Color.RED);

        setLayout(new GridLayout(4, 1, 10, 10));

        add(btnPatient);
        add(btnRoom);
        add(btnSave);
        add(btnWipe);
    }

    public JButton getBtnPatient() {
        return btnPatient;
    }

    public JButton getBtnRoom() {
        return btnRoom;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnWipe() {
        return btnWipe;
    }
}
