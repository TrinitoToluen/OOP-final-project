import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import forms.*;

public class Controller {
    PatientList patientList;
    RoomList roomList;

    private JFrame mainFrame;
    private JPanel mainPanel;
    private SelectionView selectionView;
    private PatientView patientView;
    private RoomView roomView;

    public Controller(PatientView patientView, RoomView roomView, String patientFile, String roomFile) {
        this.patientList = new PatientList();
        this.patientList.readFromFile(patientFile);
        this.roomList = new RoomList();
        this.roomList.readFromFile(roomFile);

        mainFrame = new JFrame("Patient Management System");
        mainPanel = new JPanel(new CardLayout());

        this.selectionView = new SelectionView();
        this.selectionView.getBtnPatient().addActionListener(e -> showPatientView());
        this.selectionView.getBtnRoom().addActionListener(e -> showRoomView());
        this.selectionView.getBtnSave().addActionListener(e -> saveData(patientFile, roomFile));
        this.selectionView.getBtnWipe().addActionListener(e -> wipeData());

        this.patientView = patientView;
        patientView.updatePatientTable(patientList.getPatients());
        this.patientView.getBtnBack().addActionListener(e -> showSelectionView());
        this.patientView.getBtnAddPatient().addActionListener(e -> showAddPatientForm());
        this.patientView.getBtnRemovePatient().addActionListener(e -> showDelPatientForm());
        this.patientView.getBtnEditPatient().addActionListener(e -> showEditPatientForm());
        this.patientView.getBtnFilterPatients().addActionListener(e -> showFilterPatientForm());
        this.patientView.getBtnClearFilter().addActionListener(e -> clearPatientList());

        this.roomView = roomView;
        roomView.updateRoomTable(roomList.getRooms());
        this.roomView.getBtnBack().addActionListener(e -> showSelectionView());
        this.roomView.getBtnAddRoom().addActionListener(e -> showAddRoomForm());
        this.roomView.getBtnDelRoom().addActionListener(e -> showDelRoomForm());
        this.roomView.getBtnAddRecord().addActionListener(e -> showAddRecordForm());
        JTable roomTable = this.roomView.getRoomTable();
        roomTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = roomTable.getSelectedRow();
                if (selectedRow != -1) {
                    int roomID = (int) roomTable.getValueAt(selectedRow, 0);
                    showRecordsOfRoom(roomID);
                }
            }
        });
        JTable recordTable = this.roomView.getRecordTable();
        recordTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = recordTable.getSelectedRow();
                if (selectedRow != -1) {
                    int recordID = (int) recordTable.getValueAt(selectedRow, 0);
                    int roomID = (int) roomTable.getValueAt(roomTable.getSelectedRow(), 0);
                    showRecordInfo(roomID, recordID);
                    // Unselect the row
                    recordTable.getSelectionModel().clearSelection();
                }
            }
        });

        mainPanel.add(this.selectionView, "SelectionView");
        mainPanel.add(this.patientView, "PatientView");
        mainPanel.add(this.roomView, "RoomView");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(800, 800));
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void showAddPatientForm() {
        AddPatientForm form = new AddPatientForm();
        form.getBtnSubmit().addActionListener(e -> {
            Map<String, String> data = form.getData();
            // Check if any of the fields are empty
            if (data.values().stream().anyMatch(String::isEmpty)) {
                form.showErrorMessage("Please fill in all fields");
                return;
            }
            // Check if age is a number
            try {
                Integer.parseInt(data.get("age"));
            } catch (NumberFormatException ex) {
                form.showErrorMessage("Age must be a number");
                return;
            }

            // Add patient to list
            Patient newPatient = new Patient(data.get("name"), 
                                            data.get("gender"), 
                                            Integer.parseInt(data.get("age")), 
                                            data.get("email"), 
                                            data.get("phone"), 
                                            data.get("address"));
            patientList.addPatient(newPatient);
            patientView.updatePatientTable(patientList.getPatients());
            form.dispose();
        });
        form.setVisible(true);
    }

    private void showDelPatientForm(){
        DeletePatientForm form = new DeletePatientForm();
        form.getBtnSubmit().addActionListener(e -> {
            Map<String, String> data = form.getData();
            // Check if any of the fields are empty
            if (data.values().stream().anyMatch(String::isEmpty)) {
                form.showErrorMessage("Please fill in all fields");
                return;
            }

            // Check if ID is a number
            try {
                Integer.parseInt(data.get("id"));
            } catch (NumberFormatException ex) {
                form.showErrorMessage("ID must be a number");
                return;
            }

            // Check if patient exists
            int ID = Integer.parseInt(data.get("id"));
            Patient patient = patientList.getPatient(ID);
            if (patient == null || !patient.getName().equals(data.get("name"))) {
                form.showErrorMessage("Patient does not exist");
                return;
            }

            // Delete patient from list
            patientList.deletePatient(ID);

            patientView.updatePatientTable(patientList.getPatients());
            form.dispose();
        });
        form.setVisible(true);
    }

    private void showEditPatientForm(){
        EditPatientForm form = new EditPatientForm();
        form.getBtnSubmit().addActionListener(e -> {
            Map<String, String> data = form.getData();
            // Check if ID is a number
            try {
                Integer.parseInt(data.get("id"));
            } catch (NumberFormatException ex) {
                form.showErrorMessage("ID must be a number");
                return;
            }

            // Check if age is a number
            try {
                Integer.parseInt(data.get("age"));
            } catch (NumberFormatException ex) {
                form.showErrorMessage("Age must be a number");
                return;
            }

            int ID = Integer.parseInt(data.get("id"));
            Patient patient = patientList.getPatient(ID);

            // Check if patient exists
            if (patient == null) {
                form.showErrorMessage("Patient does not exist");
                return;
            }

            // Get through all the fields and update the patient if they are not empty
            if (!data.get("name").isEmpty()) {
                patient.setName(data.get("name"));
            }

            if (!data.get("gender").isEmpty()) {
                patient.setGender(data.get("gender"));
            }

            if (!data.get("age").isEmpty()) {
                patient.setAge(Integer.parseInt(data.get("age")));
            }

            if (!data.get("email").isEmpty()) {
                patient.setEmail(data.get("email"));
            }

            if (!data.get("phone").isEmpty()) {
                patient.setPhone(data.get("phone"));
            }

            if (!data.get("address").isEmpty()) {
                patient.setAddress(data.get("address"));
            }

            patientView.updatePatientTable(patientList.getPatients());
            form.dispose();
        });
        form.setVisible(true);
    }

    void showFilterPatientForm(){
        FilerPatientAgeForm form = new FilerPatientAgeForm();
        form.getBtnSubmit().addActionListener(e -> {
            Map<String, String> data = form.getData();
            String gtString = data.get("greater");
            String ltString = data.get("less");
            String eqString = data.get("equal");

            LinkedList<Patient> filteredPatients = patientList.filterPatients(p -> {
                if (!gtString.isEmpty()) {
                    if (p.getAge() <= Integer.parseInt(gtString)) {
                        return false;
                    }
                }

                if (!ltString.isEmpty()) {
                    if (p.getAge() >= Integer.parseInt(ltString)) {
                        return false;
                    }
                }

                if (!eqString.isEmpty()) {
                    if (p.getAge() != Integer.parseInt(eqString)) {
                        return false;
                    }
                }

                return true;
            });

            patientView.updatePatientTable(filteredPatients);
            form.dispose();
        });
        form.setVisible(true);
    }

    private void clearPatientList() {
        patientView.updatePatientTable(patientList.getPatients());
    }

    private void showAddRoomForm() {
        AddRoomForm form = new AddRoomForm();
        form.getBtnSubmit().addActionListener(e -> {
            Map<String, String> data = form.getData();
            // Check if any of the fields are empty
            if (data.values().stream().anyMatch(String::isEmpty)) {
                form.showErrorMessage("Please fill in all fields");
                return;
            }

            // Add room to list
            TreatmentRoom newRoom = new TreatmentRoom(data.get("name"));
            roomList.addRoom(newRoom);
            roomView.updateRoomTable(roomList.getRooms());
            form.dispose();
        });
        form.setVisible(true);
    }

    private void showDelRoomForm(){
        DeleteRoomForm form = new DeleteRoomForm();
        form.getBtnSubmit().addActionListener(e -> {
            Map<String, String> data = form.getData();
            // Check if any of the fields are empty
            if (data.values().stream().anyMatch(String::isEmpty)) {
                form.showErrorMessage("Please fill in all fields");
                return;
            }

            // Check if ID is a number
            try {
                Integer.parseInt(data.get("id"));
            } catch (NumberFormatException ex) {
                form.showErrorMessage("ID must be a number");
                return;
            }

            // Check if room exists
            int ID = Integer.parseInt(data.get("id"));
            TreatmentRoom room = roomList.getRoom(ID);
            if (room == null) {
                form.showErrorMessage("Room ID does not exist");
                return;
            }

            if (!room.getName().equals(data.get("name"))) {
                form.showErrorMessage("Room name does not match ID");
                return;
            }

            // Delete room from list
            roomList.removeRoom(ID);
            roomView.updateRoomTable(roomList.getRooms());
            form.dispose();
        });
        form.setVisible(true);
    }

    private void showAddRecordForm(){
        AddMedRecordForm form = new AddMedRecordForm();
        form.getBtnSubmit().addActionListener(e -> {
            Map<String, String> data = form.getData();

            // Check if any of the fields are empty
            if (data.values().stream().anyMatch(String::isEmpty)) {
                form.showErrorMessage("Please fill in all fields");
                return;
            }

            // Check if ID is a number
            try {
                Integer.parseInt(data.get("room_id"));
            } catch (NumberFormatException ex) {
                form.showErrorMessage("ID must be a number");
                return;
            }

            // Check if patientID is a number
            try {
                Integer.parseInt(data.get("patient_id"));
            } catch (NumberFormatException ex) {
                form.showErrorMessage("Patient ID must be a number");
                return;
            }

            // Check if room exists
            int roomID = Integer.parseInt(data.get("room_id"));
            TreatmentRoom room = roomList.getRoom(roomID);
            if (room == null) {
                form.showErrorMessage("Room ID does not exist");
                return;
            }

            // Check if patient exists
            int patientID = Integer.parseInt(data.get("patient_id"));
            Patient patient = patientList.getPatient(patientID);
            if (patient == null) {
                form.showErrorMessage("Patient ID does not exist");
                return;
            }

            // Add record to room
            MedRecord record = new MedRecord(patientID, 
                                            data.get("date"), 
                                            data.get("diagnosis"), 
                                            data.get("prescription"), 
                                            data.get("notes"));

            room.addMedRecord(record);

            form.dispose();
        });
        form.setVisible(true);
    }

    private void showRecordsOfRoom(int id){
        TreatmentRoom room = roomList.getRoom(id);
        roomView.updateRecordTable(room.getMedRecords());
    }

    private void showRecordInfo(int recordID, int roomID){
        TreatmentRoom room = roomList.getRoom(roomID);
        MedRecord record = room.getMedRecord(recordID);
        Patient patient = patientList.getPatient(record.getPatientID());
        Map<String, String> info = new HashMap<String, String>();
        info.put("Treatment room", room.getName());
        info.put("Patient name", patient.getName());
        info.put("Patient age", Integer.toString(patient.getAge()));
        info.put("Patient email", patient.getEmail());
        info.put("Patient phone", patient.getPhone());
        info.put("Patient address", patient.getAddress());
        info.put("Record date", record.getDate());
        info.put("Record diagnosis", record.getDiagnosis());
        info.put("Record prescription", record.getPrescription());
        info.put("Record notes", record.getNotes());
        RecordInfo form = new RecordInfo(info);
        form.setVisible(true);
    }

    private void showSelectionView() {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "SelectionView");
    }

    private void showPatientView() {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "PatientView");
    }

    private void showRoomView() {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "RoomView");
    }

    public Boolean isRunning(){
        return this.mainFrame.isVisible();
    }

    public void saveData(String patientFile, String roomFile){
        this.patientList.writeToFile(patientFile);
        this.roomList.writeToFile(roomFile);
    }

    public void wipeData(){
        this.patientList = new PatientList();
        this.roomList = new RoomList();

        this.patientView.updatePatientTable(patientList.getPatients());
        this.roomView.updateRoomTable(roomList.getRooms());
        this.roomView.updateRecordTable(new LinkedList<MedRecord>());
    }
}