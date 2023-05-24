import java.io.Serializable;

public class MedRecord implements Serializable{
    private static int count = 0;
    private int id;
    private int patientID;
    private String date;
    private String diagnosis;
    private String prescription;
    private String notes;

    public MedRecord() {
        this.id = ++count;
    }

    public MedRecord(int patientID, String date) {
        this.id = ++count;
        this.patientID = patientID;
        this.date = date;
    }

    public MedRecord(int patientID, String date, String diagnosis, String prescription, String notes) {
        this.id = ++count;
        this.patientID = patientID;
        this.date = date;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.notes = notes;
        count = Math.max(count, id);
    }

    // Getters and Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientID() {
        return this.patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getDate() {
        return String.format("%s", this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return String.format("%s", this.diagnosis);
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return String.format("%s", this.prescription);
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getNotes() {
        return String.format("%s", this.notes);
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return String.format("%04d\t%04d\t%-10s\n%s\n%s\n%s", this.id, this.patientID, this.date,
                this.diagnosis, this.prescription, this.notes);
    }

    public Object[] toObjects() {
        return new Object[] { this.id, this.patientID, this.date, this.diagnosis, this.prescription};
    }

}
