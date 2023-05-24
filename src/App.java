
public class App {
    public static void main(String[] args) {
        String patientFile = "data/patients.bin";
        String roomFile = "data/rooms.bin";

        PatientView patientView = new PatientView();
        RoomView roomView = new RoomView();
        new Controller(patientView, roomView, patientFile, roomFile);
    }
}