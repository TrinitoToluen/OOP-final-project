import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PatientList implements FileInteraction {

    private ArrayList<Patient> patients;

    public PatientList() {
        this.patients = new ArrayList<Patient>();
    }

    public PatientList(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void removePatient(int id) {
        for (int i = 0; i < this.patients.size(); i++) {
            if (this.patients.get(i).getId() == id) {
                this.patients.remove(i);
                break;
            }
        }
    }

    public LinkedList<Patient> getPatients() {
        return new LinkedList<Patient>(this.patients);
    }

    public Patient getPatient(int id){
        for (Patient patient : this.patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public LinkedList<Patient> filterPatients(Predicate<Patient> predicate) {
        LinkedList<Patient> filteredPatients = new LinkedList<Patient>();
        for (Patient patient : this.patients) {
            if (predicate.test(patient)) {
                filteredPatients.add(patient);
            }
        }
        return filteredPatients;
    }

    public void deletePatient(int id){
        for (int i = 0; i < this.patients.size(); i++) {
            if (this.patients.get(i).getId() == id) {
                this.patients.remove(i);
                break;
            }
        }
    }

    public String toString() {
        String result = "";
        for (Patient patient : this.patients) {
            result += patient.toString() + "\n";
        }
        return result;
    }

    @Override
    public void writeToFile(String filename) {
        // Write to binary file
        try {
            FileOutputStream fos = new FileOutputStream(new File(filename));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.patients);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked") // Suppress warning for casting Object to ArrayList<Patient>
    public void readFromFile(String filename) {
        // Read from binary file
        try {
            FileInputStream fis = new FileInputStream(new File(filename));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            
            this.patients = (ArrayList<Patient>) data;

            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}