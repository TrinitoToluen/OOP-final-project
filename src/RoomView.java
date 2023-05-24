import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RoomView extends JPanel {
    private JButton btnBack;
    private JButton btnAddRoom;
    private JButton btnDelRoom;
    private JButton btnAddRecord;

    JTable roomTable;
    private DefaultTableModel roomTableModel;

    JTable recordTable;
    private DefaultTableModel recordTableModel;

    public RoomView() {
        setLayout(new BorderLayout());

        // Create the button panel with three buttons on the top
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        btnBack = new JButton("Back");
        btnAddRoom = new JButton("Add Room");
        btnDelRoom = new JButton("Delete Room");
        btnAddRecord = new JButton("Add Record");
        buttonPanel.add(btnBack);
        buttonPanel.add(btnAddRoom);
        buttonPanel.add(btnDelRoom);
        buttonPanel.add(btnAddRecord);
        add(buttonPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the room table panel
        JPanel leftTablePanel = new JPanel();
        leftTablePanel.setLayout(new BorderLayout());
        leftTablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        roomTableModel = new DefaultTableModel();
        roomTableModel.addColumn("ID");
        roomTableModel.addColumn("Name");
        roomTable = new JTable(roomTableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.setPreferredSize(new Dimension(200, 700));

        leftTablePanel.add(new JLabel("ROOMS"), BorderLayout.NORTH);
        leftTablePanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(leftTablePanel, BorderLayout.WEST);

        // Create the record table panel
        JPanel rightTablePanel = new JPanel();
        rightTablePanel.setLayout(new BorderLayout());
        rightTablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        recordTableModel = new DefaultTableModel();
        recordTableModel.addColumn("ID");
        recordTableModel.addColumn("Patient");
        recordTableModel.addColumn("Date");        
        recordTableModel.addColumn("Diagnosis");
        recordTableModel.addColumn("Prescription");

        recordTable = new JTable(recordTableModel);
        JScrollPane scrollPane2 = new JScrollPane(recordTable);
        rightTablePanel.add(new JLabel("RECORDS"), BorderLayout.NORTH);
        rightTablePanel.add(scrollPane2, BorderLayout.CENTER);
        mainPanel.add(rightTablePanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    public void updateRoomTable(LinkedList<TreatmentRoom> list) {
        // Clear the table
        roomTableModel.setRowCount(0);

        // Add the rooms to the table
        for (TreatmentRoom room : list) {
            roomTableModel.addRow(room.toObjects());
        }
    }

    public void updateRecordTable(LinkedList<MedRecord> list) {
        // Clear the table
        recordTableModel.setRowCount(0);

        // Add the records to the table
        for (MedRecord record : list) {
            recordTableModel.addRow(record.toObjects());
        }
    }

    public JTable getRoomTable() {
        return roomTable;
    }

    public JTable getRecordTable() {
        return recordTable;
    }

    public JButton getBtnAddRoom() {
        return btnAddRoom;
    }

    public JButton getBtnDelRoom() {
        return btnDelRoom;
    }

    public JButton getBtnAddRecord() {
        return btnAddRecord;
    }

    public JButton getBtnBack() {
        return btnBack;
    }
}
