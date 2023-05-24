import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RoomList implements FileInteraction{
    private ArrayList<TreatmentRoom> rooms;

    public RoomList() {
        this.rooms = new ArrayList<TreatmentRoom>();
    }

    public RoomList(ArrayList<TreatmentRoom> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(TreatmentRoom room) {
        this.rooms.add(room);
    }

    public void removeRoom(int id) {
        for (int i = 0; i < this.rooms.size(); i++) {
            if (this.rooms.get(i).getId() == id) {
                this.rooms.remove(i);
                break;
            }
        }
    }

    public LinkedList<TreatmentRoom> getRooms(){
        return new LinkedList<TreatmentRoom>(this.rooms);
    }

    public TreatmentRoom getRoom(int id) {
        for (TreatmentRoom room : this.rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void writeToFile(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(filename));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.rooms);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void readFromFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(new File(filename));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            
            this.rooms = (ArrayList<TreatmentRoom>) data;

            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String toString() {
        String result = "";
        for (TreatmentRoom room : this.rooms) {
            result += room.getName() + "\n";
        }
        return result;
    }
}
