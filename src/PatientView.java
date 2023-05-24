import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

public class PatientView extends JPanel {
    private JButton btnBack;
    private JButton btnAddPatient;
    private JButton btnRemovePatient;
    private JButton btnEditPatient;
    private JButton btnFilterPatients;
    private JButton btnClearFilter;

    private JTable patientTable;
    private DefaultTableModel tableModel;

    public PatientView() {

        btnBack = new JButton("Back");
        btnAddPatient = new JButton("Add Patient");
        btnRemovePatient = new JButton("Remove Patient");
        btnEditPatient = new JButton("Edit Patient");
        btnFilterPatients = new JButton("Filter by Age");
        btnClearFilter = new JButton("Clear Filter");

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Age");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Address");

        // Create the patient table with the table model
        patientTable = new JTable(tableModel);

        // Create a scroll pane and add the patient table to it
        JScrollPane scrollPane = new JScrollPane(patientTable);

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(600, 700));

        // Add the scroll pane to the PatientView
        add(btnBack);
        add(btnAddPatient);
        add(btnRemovePatient);
        add(btnEditPatient);
        add(btnFilterPatients);
        add(btnClearFilter);

        add(scrollPane);
    }

    public void updatePatientTable(LinkedList<Patient> list){
        // Clear the table
        tableModel.setRowCount(0);

        // Add the patients to the table
        for (Patient patient : list) {
            tableModel.addRow(patient.toObjects());
        }
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnAddPatient() {
        return btnAddPatient;
    }

    public JButton getBtnRemovePatient() {
        return btnRemovePatient;
    }

    public JButton getBtnEditPatient() {
        return btnEditPatient;
    }

    public JButton getBtnFilterPatients() {
        return btnFilterPatients;
    }

    public JButton getBtnClearFilter() {
        return btnClearFilter;
    }
}
