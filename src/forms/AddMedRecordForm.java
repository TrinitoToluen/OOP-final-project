package forms;

import java.util.Map;

import javax.swing.*;

public class AddMedRecordForm extends Form {
    private JPanel mainPanel;

    private JTextField txtRoomID;
    private JTextField txtPatientID;
    private JTextField txtDate;
    private JTextArea txtDiagnosis;
    private JTextArea txtPrescription;
    private JTextArea txtNotes;

    private JButton btnAddMedRecord;

    public AddMedRecordForm(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        txtRoomID = new JTextField(20);
        txtPatientID = new JTextField(20);
        txtDate = new JTextField(20);
        txtDiagnosis = new JTextArea(2, 20);
        txtPrescription = new JTextArea(2, 20);
        txtNotes = new JTextArea(2, 20);

        txtDiagnosis.setLineWrap(true);
        txtDiagnosis.setWrapStyleWord(true);
        txtPrescription.setLineWrap(true);
        txtPrescription.setWrapStyleWord(true);
        txtNotes.setLineWrap(true);
        txtNotes.setWrapStyleWord(true);

        txtDiagnosis.setAlignmentX(LEFT_ALIGNMENT);
        txtPrescription.setAlignmentX(LEFT_ALIGNMENT);
        txtNotes.setAlignmentX(LEFT_ALIGNMENT);

        btnAddMedRecord = new JButton("Add Medical Record");

        mainPanel.add(new JLabel("Room ID"));
        mainPanel.add(txtRoomID);
        mainPanel.add(new JLabel("Patient ID"));
        mainPanel.add(txtPatientID);
        mainPanel.add(new JLabel("Date"));
        mainPanel.add(txtDate);
        mainPanel.add(new JLabel("Diagnosis"));
        mainPanel.add(txtDiagnosis);
        mainPanel.add(new JLabel("Prescription"));
        mainPanel.add(txtPrescription);
        mainPanel.add(new JLabel("Notes"));
        mainPanel.add(txtNotes);
        mainPanel.add(btnAddMedRecord);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = new java.util.HashMap<>();
        data.put("room_id", txtRoomID.getText());
        data.put("patient_id", txtPatientID.getText());
        data.put("date", txtDate.getText());
        data.put("diagnosis", txtDiagnosis.getText());
        data.put("prescription", txtPrescription.getText());
        data.put("notes", txtNotes.getText());

        return data;
    }

    @Override
    public JButton getBtnSubmit() {
        return btnAddMedRecord;
    }
    
}
