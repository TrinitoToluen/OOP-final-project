package menu;

import java.util.*;
import java.io.*;
import java.lang.*;
import patient.*;
import medrecord.*;
import room.*;

public class Menu {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Hospital Management System");
        System.out.println("Please select an option:");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Medical Record");
        System.out.println("3. Add Room");
        System.out.println("4. Display Patient and respective Medical Record");
        System.out.println("5. Display Room");
        System.out.println("6. Delete patient (medical record also removed). ");
        System.out.println("7. Delete room");
        System.out.println("8. Add a new patient into the room");
        System.out.println("9. Delete a patient from the room");
        System.out.println("10. Search patient info by age");
        System.out.println("11. Exit");
        Scanner input = new Scanner(System.in);
        int patient_count = 0;
        int record_count = 0;
        int room_count = 0;
        ArrayList<Patient> patient_list = new ArrayList<Patient>();
        ArrayList<MedRecord> record_list = new ArrayList<MedRecord>();
        HashMap<Patient, MedRecord> patient_infos = new HashMap<Patient, MedRecord>();
        ArrayList<Room> room_list = new ArrayList<Room>();

        final String URL = "E:/Special Projects/JavaBTL/data.txt";
        File file = new File(URL);
        OutputStream opStream = new FileOutputStream(file);
        OutputStreamWriter opWriter = new OutputStreamWriter(opStream);
        while (true) {
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    patient_count++;
                    System.out.println("Enter the information of the No." + patient_count + " patient");
                    Patient pt = new Patient();
                    System.out.println("Enter Patient Name: ");
                    String name = input.next();
                    pt.setName(name);
                    System.out.println("Enter Patient Age: ");
                    int age = input.nextInt();
                    pt.setAge(age);
                    System.out.println("Enter Patient Gender: ");
                    String gender = input.next();
                    pt.setGender(gender);
                    System.out.println("Enter Patient Height: ");
                    double height = input.nextDouble();
                    pt.setHeight(height);
                    System.out.println("Enter Patient Weight: ");
                    double weight = input.nextDouble();
                    pt.setWeight(weight);
                    System.out.println("Enter Patient Address: ");
                    String address = input.next();
                    pt.setAddress(address);
                    System.out.println("Enter Patient Phone: ");
                    String phone = input.next();
                    pt.setPhone(phone);
                    System.out.println("Enter Patient Email: ");
                    String email = input.next();
                    pt.setEmail(email);
                    patient_list.add(pt);
                    System.out.println("Do you want to display the information of the patient? (Y/N)");
                    char dec1 = input.next().charAt(0);
                    if (dec1 == 'Y' || dec1 == 'y') {
                        opWriter.write("Patient Information");
                        opWriter.write("\n");
                        opWriter.write("Name: " + pt.getName());
                        opWriter.write("\n");
                        opWriter.write("Age: " + pt.getAge());
                        opWriter.write("\n");
                        opWriter.write("Gender: " + pt.getGender());
                        opWriter.write("\n");
                        opWriter.write("Height: " + pt.getHeight());
                        opWriter.write("\n");
                        opWriter.write("Weight: " + pt.getWeight());
                        opWriter.write("\n");
                        opWriter.write("Address: " + pt.getAddress());
                        opWriter.write("\n");
                        opWriter.write("Phone: " + pt.getPhone());
                        opWriter.write("\n");
                        opWriter.write("Email: " + pt.getEmail());
                        opWriter.write("\n");
                    }
                    opWriter.write("\n");
                    break;

                case 2:
                    System.out.println("Select the index of the patient whose medical record you want to add:");
                    System.out.println(
                            "You can only add medical record for the patients who have been added to the system.");
                    int patient_idx = input.nextInt();
                    while (patient_idx > patient_count) {
                        System.out.println("Enter the index of the patient again: ");
                        patient_idx = input.nextInt();
                    }
                    record_count++;
                    System.out.println("Enter the medical information of the No." + patient_count + " patient");
                    MedRecord mr = new MedRecord();

                    String that_patient_name = patient_list.get(patient_idx - 1).getName();
                    int that_patient_age = patient_list.get(patient_idx - 1).getAge();
                    String that_patient_gender = patient_list.get(patient_idx - 1).getGender();
                    double that_patient_height = patient_list.get(patient_idx - 1).getHeight();
                    double that_patient_weight = patient_list.get(patient_idx - 1).getWeight();
                    String that_patient_address = patient_list.get(patient_idx - 1).getAddress();
                    String that_patient_phone = patient_list.get(patient_idx - 1).getPhone();
                    String that_patient_email = patient_list.get(patient_idx - 1).getEmail();

                    mr.setAll(that_patient_name, that_patient_age, that_patient_gender, that_patient_height,
                            that_patient_weight, that_patient_address, that_patient_phone, that_patient_email);

                    System.out.println("Enter the diagnosis: ");
                    String diagnosis = input.next();
                    mr.setDiagnosis(diagnosis);
                    System.out.println("Enter the treatment: ");
                    String treatment = input.next();
                    mr.setTreatment(treatment);
                    System.out.println("Enter the date:");
                    String date = input.next();
                    mr.setDate(date);
                    System.out.println("Enter the Id: ");
                    int id = input.nextInt();
                    mr.setId(id);
                    System.out.println("Enter the cost: ");
                    double cost = input.nextDouble();
                    mr.setCost(cost);
                    record_list.add(mr);
                    patient_infos.put(patient_list.get(patient_idx - 1), mr);
                    System.out.println("Do you want to display the information of the medical record? (Y/N)");
                    char dec2 = input.next().charAt(0);
                    if (dec2 == 'Y' || dec2 == 'y') {
                        opWriter.write("Medical Record Information");
                        opWriter.write("\n");
                        opWriter.write("Name: " + mr.getName());
                        opWriter.write("\n");
                        opWriter.write("Age: " + mr.getAge());
                        opWriter.write("\n");
                        opWriter.write("Gender: " + mr.getGender());
                        opWriter.write("\n");
                        opWriter.write("Height: " + mr.getHeight());
                        opWriter.write("\n");
                        opWriter.write("Weight: " + mr.getWeight());
                        opWriter.write("\n");
                        opWriter.write("Address: " + mr.getAddress());
                        opWriter.write("\n");
                        opWriter.write("Phone: " + mr.getPhone());
                        opWriter.write("\n");
                        opWriter.write("Email: " + mr.getEmail());
                        opWriter.write("\n");
                        opWriter.write("Diagnosis: " + mr.getDiagnosis());
                        opWriter.write("\n");
                        opWriter.write("Treatment: " + mr.getTreatment());
                        opWriter.write("\n");
                        opWriter.write("Date: " + mr.getDate());
                        opWriter.write("\n");
                        opWriter.write("Id: " + mr.getId());
                        opWriter.write("\n");
                        opWriter.write("Cost: " + mr.getCost());
                        opWriter.write("\n");

                    }
                    opWriter.write("\n");
                    break;

                case 3:
                    room_count++;
                    System.out.println("Enter the information of the No." + room_count + " room");
                    Room rm = new Room();
                    System.out.println("Enter the room number: ");
                    int room_num = input.nextInt();
                    rm.setRoomNo(room_num);
                    System.out.println("Enter the room type: ");
                    String room_type = input.next();
                    rm.setRoomType(room_type);
                    System.out.println("Enter the room cost: ");
                    double room_cost = input.nextDouble();
                    rm.setRoomCost(room_cost);
                    System.out.println("Enter the room status: ");
                    String room_status = input.next();
                    rm.setRoomStatus(room_status);
                    room_list.add(rm);
                    System.out.println("Do you want to display the information of the room? (Y/N)");
                    char dec3 = input.next().charAt(0);
                    if (dec3 == 'Y' || dec3 == 'y') {
                        opWriter.write("Room No: " + rm.getRoomNo());
                        opWriter.write("\n");
                        opWriter.write("Room Status: " + rm.getRoomStatus());
                        opWriter.write("\n");
                        opWriter.write("Room Cost: " + rm.getRoomCost());
                        opWriter.write("\n");
                        opWriter.write("Records: ");
                        opWriter.write("\n");
                        opWriter.write("This room currently has " + rm.getRecords().size() + " patients.");
                        opWriter.write("\n");
                        for (MedRecord recordz : rm.getRecords()) {
                            opWriter.write("Diagnosis: " + recordz.getDiagnosis());
                            opWriter.write("\n");
                            opWriter.write("Treatment: " + recordz.getTreatment());
                            opWriter.write("\n");
                            opWriter.write("Date: " + recordz.getDate());
                            opWriter.write("\n");
                            opWriter.write("Id: " + recordz.getId());
                            opWriter.write("\n");
                            opWriter.write("Cost: " + recordz.getCost());
                            opWriter.write("\n");
                        }
                    }
                    opWriter.write("\n");
                    break;


                case 4:
                    System.out.println("Enter the index of the patient you want to search: ");
                    System.out.println("You can only search within the patients who have been added to the system.");
                    System.out.println("You can also not search for a patient whose record has not been added to the system.");
                    int idx = input.nextInt();
                    while (idx > patient_count || !patient_infos.containsKey(patient_list.get(idx - 1))) {
                        System.out.println("Enter the index of the patient again: ");
                        idx = input.nextInt();
                    }
                    opWriter.write("Patient Information");
                    opWriter.write("\n");
                    opWriter.write("Name: " + patient_list.get(idx - 1).getName());
                    opWriter.write("\n");
                    opWriter.write("Age: " + patient_list.get(idx - 1).getAge());
                    opWriter.write("\n");
                    opWriter.write("Gender: " + patient_list.get(idx - 1).getGender());
                    opWriter.write("\n");
                    opWriter.write("Height: " + patient_list.get(idx - 1).getHeight());
                    opWriter.write("\n");
                    opWriter.write("Weight: " + patient_list.get(idx - 1).getWeight());
                    opWriter.write("\n");
                    opWriter.write("Address: " + patient_list.get(idx - 1).getAddress());
                    opWriter.write("\n");
                    opWriter.write("Phone: " + patient_list.get(idx - 1).getPhone());
                    opWriter.write("\n");
                    opWriter.write("Email: " + patient_list.get(idx - 1).getEmail());
                    opWriter.write("\n");
                    opWriter.write("Diagnosis: " + patient_infos.get(patient_list.get(idx - 1)).getDiagnosis());
                    opWriter.write("\n");
                    opWriter.write("Treatment: " + patient_infos.get(patient_list.get(idx - 1)).getTreatment());
                    opWriter.write("\n");
                    opWriter.write("Date: " + patient_infos.get(patient_list.get(idx - 1)).getDate());
                    opWriter.write("\n");
                    opWriter.write("Id: " + patient_infos.get(patient_list.get(idx - 1)).getId());
                    opWriter.write("\n");
                    opWriter.write("Cost: " + patient_infos.get(patient_list.get(idx - 1)).getCost());
                    opWriter.write("\n");
                    opWriter.write("\n");
                    break;

                case 5:
                    System.out.println("Enter the index of the room you want to search: ");
                    System.out.println("You can only search within the rooms that have been added to the system.");
                    int idxx = input.nextInt();
                    while (idxx > room_count) {
                        System.out.println("Enter the index of the room again: ");
                        idxx = input.nextInt();
                    }
                    opWriter.write("Room number: " + room_list.get(idxx - 1).getRoomNo());
                    opWriter.write("\n");
                    opWriter.write("Room type: " + room_list.get(idxx - 1).getRoomType());
                    opWriter.write("\n");
                    opWriter.write("Room cost: " + room_list.get(idxx - 1).getRoomCost());
                    opWriter.write("\n");
                    opWriter.write("Room status: " + room_list.get(idxx - 1).getRoomStatus());
                    opWriter.write("\n");
                    opWriter.write("Records: ");
                    opWriter.write("\n");
                    opWriter.write("This room currently has " + room_list.get(idxx - 1).getRecords().size() + " patients.");
                    opWriter.write("\n");
                    for(int i = 0; i < room_list.get(idxx - 1).getRecords().size(); i++){
                        opWriter.write("Patient no: " + (i + 1) + "in the room: ");
                        opWriter.write("\n");
                        opWriter.write("Name: " + room_list.get(idxx - 1).getRecords().get(i).getName());
                        opWriter.write("\n");
                        opWriter.write("Age: " + room_list.get(idxx - 1).getRecords().get(i).getAge());
                        opWriter.write("\n");
                        opWriter.write("Gender: " + room_list.get(idxx - 1).getRecords().get(i).getGender());
                        opWriter.write("\n");
                        opWriter.write("Height: " + room_list.get(idxx - 1).getRecords().get(i).getHeight());
                        opWriter.write("\n");
                        opWriter.write("Weight: " + room_list.get(idxx - 1).getRecords().get(i).getWeight());
                        opWriter.write("\n");
                        opWriter.write("Address: " + room_list.get(idxx - 1).getRecords().get(i).getAddress());
                        opWriter.write("\n");
                        opWriter.write("Phone: " + room_list.get(idxx - 1).getRecords().get(i).getPhone());
                        opWriter.write("\n");
                        opWriter.write("Email: " + room_list.get(idxx - 1).getRecords().get(i).getEmail());
                        opWriter.write("\n");
                        opWriter.write("Diagnosis: " + room_list.get(idxx - 1).getRecords().get(i).getDiagnosis());
                        opWriter.write("\n");
                        opWriter.write("Treatment: " + room_list.get(idxx - 1).getRecords().get(i).getTreatment());
                        opWriter.write("\n");
                        opWriter.write("Date: " + room_list.get(idxx - 1).getRecords().get(i).getDate());
                        opWriter.write("\n");
                        opWriter.write("Id: " + room_list.get(idxx - 1).getRecords().get(i).getId());
                        opWriter.write("\n");
                        opWriter.write("Cost: " + room_list.get(idxx - 1).getRecords().get(i).getCost());
                        opWriter.write("\n");
                    }
                    opWriter.write("\n");
                    break;
                
                case 7:
                    System.out.println("Enter the index of the room you want to delete: ");
                    System.out.println("You can only delete a room that has been added to the system.");
                    int idx_del2 = input.nextInt();
                    while(idx_del2 > room_count){
                        System.out.println("Enter the index of the room again: ");
                        idx_del2 = input.nextInt();
                    }
                    Room yy = room_list.get(idx_del2 - 1);
                    room_list.remove(idx_del2 - 1);
                    System.out.println("Room deleted successfully.");
                    opWriter.write("Room deleted successfully.");
                    opWriter.write("\n");
                    opWriter.write("\n");
                    break;

                case 6:
                    System.out.println("Enter the index of the patient you want to delete: ");
                    System.out.println("You can only delete a patient who has been added to the system.");
                    int idx_del = input.nextInt();
                    while (idx_del > patient_count || !patient_infos.containsKey(patient_list.get(idx_del - 1))) {
                        System.out.println("Enter the index of the patient again: ");
                        idx_del = input.nextInt();
                    }
                    Patient xx = patient_list.get(idx_del - 1);
                    patient_list.remove(idx_del - 1);
                    patient_infos.remove(xx);
                    patient_count--;
                    System.out.println("Patient deleted successfully.");
                    opWriter.write("Patient deleted successfully.");
                    opWriter.write("\n");
                    break;

                case 8:
                    System.out.println("Enter the index of the patient: ");
                    System.out.println("You can only search within the patients who have been added to the system.");
                    System.out.println("You can also not search for a patient whose record has not been added to the system.");
                    int idx1 = input.nextInt();
                    while (idx1 > patient_count || !patient_infos.containsKey(patient_list.get(idx1 - 1))) {
                        System.out.println("Enter the index of the patient again: ");
                        idx = input.nextInt();
                    }
                    System.out.println("Enter the index of the room: ");
                    System.out.println("You can only search within the rooms that have been added to the system.");
                    int idx2 = input.nextInt();
                    while (idx2 > room_count) {
                        System.out.println("Enter the index of the room again: ");
                        idx2 = input.nextInt();
                    }
                    room_list.get(idx2 - 1).setRecords(record_list.get(idx1 - 1));
                    System.out.println("The patient has been added to the room.");
                    opWriter.write("The patient has been added to the room.");
                    opWriter.write("\n");
                    if (room_list.get(idx2 - 1).getRecords().size() <= 1)
                        opWriter.write(
                                "The room now has " + room_list.get(idx2 - 1).getRecords().size() + " patients.");
                    else
                        opWriter.write(
                                "The room now has " + room_list.get(idx2 - 1).getRecords().size() + " patients.");
                    opWriter.write("\n");
                    opWriter.write("\n");
                    break;

                case 9:
                    System.out.println("Enter the index of the patient: ");
                    System.out.println("You can only search within the patients who have been added to the system.");
                    System.out.println(
                            "You can also not search for a patient whose record has not been added to the system.");
                    
                    int idx3 = input.nextInt();
                    while(idx3 > patient_count || !patient_infos.containsKey(patient_list.get(idx3 - 1))) {
                        System.out.println("Enter the index of the patient again: ");
                        idx3 = input.nextInt();
                    }
                    System.out.println("Enter the index of the room: ");
                    int idx4 = input.nextInt();
                    room_list.get(idx4 - 1).getRecords().remove(idx3 - 1);
                    System.out.println("The patient has been removed from the room.");
                    opWriter.write("The patient has been removed from the room.");
                    opWriter.write("\n");
                    if(room_list.get(idx4 - 1).getRecords().size() <= 1) opWriter.write("The room now has " + room_list.get(idx4 - 1).getRecords().size() + " patients.");
                    else opWriter.write("The room now has " + room_list.get(idx4 - 1).getRecords().size() + " patients.");
                    opWriter.write("\n");
                    opWriter.write("\n");
                    break;

                case 10:
                    System.out.println("Enter the age: ");
                    int age_cnt = 0;
                    int search_age = input.nextInt();
                    opWriter.write("Displaying the information of all patients with age: " + search_age);
                    opWriter.write("\n");
                    for (int i = 0; i < patient_list.size(); i++) {
                        if (patient_list.get(i).getAge() == search_age) {
                            age_cnt++;
                            opWriter.write("The No." + age_cnt + " patient is:");
                            opWriter.write("\n");
                            opWriter.write("Name: " + patient_list.get(i).getName());
                            opWriter.write("\n");
                            opWriter.write("Age: " + patient_list.get(i).getAge());
                            opWriter.write("\n");
                            opWriter.write("Gender: " + patient_list.get(i).getGender());
                            opWriter.write("\n");
                            opWriter.write("Height: " + patient_list.get(i).getHeight());
                            opWriter.write("\n");
                            opWriter.write("Weight: " + patient_list.get(i).getWeight());
                            opWriter.write("\n");
                            opWriter.write("Address: " + patient_list.get(i).getAddress());
                            opWriter.write("\n");
                            opWriter.write("Phone: " + patient_list.get(i).getPhone());
                            opWriter.write("\n");
                            opWriter.write("Email: " + patient_list.get(i).getEmail());
                            opWriter.write("\n");
                            opWriter.write("Medical Record:");
                            opWriter.write("\n");
                            opWriter.write("Diagnosis: " + patient_infos.get(patient_list.get(i)).getDiagnosis());
                            opWriter.write("\n");
                            opWriter.write("Treatment: " + patient_infos.get(patient_list.get(i)).getTreatment());
                            opWriter.write("\n");
                            opWriter.write("Date: " + patient_infos.get(patient_list.get(i)).getDate());
                            opWriter.write("\n");
                            opWriter.write("Id: " + patient_infos.get(patient_list.get(i)).getId());
                            opWriter.write("\n");
                            opWriter.write("Cost: " + patient_infos.get(patient_list.get(i)).getCost());
                            opWriter.write("\n");
                        }
                    }
                    opWriter.write("There are " + age_cnt + " patients with the above age.");
                    opWriter.write("\n");
                    opWriter.write("\n");
                    break;

                case 11:
                    break;

                default:
                    opWriter.write("Invalid input");
                    opWriter.write("\n");
                    opWriter.write("\n");
            }
            if (choice == 11) {
                opWriter.write("Exit the program");
                opWriter.write("\n");
                opWriter.flush();
                break;
            }
        }

    }
}
