import java.util.LinkedList;
import java.io.Serializable;

public class TreatmentRoom implements Serializable{
    private static int count = 0;
    private int id;
    private String name;
    private LinkedList<MedRecord> medRecords;

    public TreatmentRoom() {
        this.id = ++count;
        this.medRecords = new LinkedList<MedRecord>();
    }

    public TreatmentRoom(String name) {
        this.id = ++count;
        this.name = name;
        this.medRecords = new LinkedList<MedRecord>();
    }

    public void addMedRecord(MedRecord medRecord) {
        this.medRecords.add(medRecord);
    }

    public MedRecord getMedRecord(int id) {
        for (MedRecord medRecord : this.medRecords) {
            if (medRecord.getId() == id) {
                return medRecord;
            }
        }
        return null;
    }

    public void removeMedRecord(int id) {
        for (MedRecord medRecord : this.medRecords) {
            if (medRecord.getId() == id) {
                this.medRecords.remove(medRecord);
                break;
            }
        }
    }

    public String toString() {
        String result = String.format("%04d\t%-20s\n", this.id, this.name);
        for (MedRecord medRecord : this.medRecords) {
            result += medRecord.toString() + "\n----\n";
        }
        return result;
    }

    // Getters and Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return String.format("%s", this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<MedRecord> getMedRecords() {
        return this.medRecords;
    }

    public void setMedRecords(LinkedList<MedRecord> medRecords) {
        this.medRecords = medRecords;
    }

    public Object[] toObjects() {
        return new Object[] {this.id, this.name};
    }
}
