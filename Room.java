package room;

import java.util.*;
import java.io.*;
import medrecord.*;



public class Room {
    private int roomNo;
    private String roomType, roomStatus;
    private double roomCost;
    private ArrayList<MedRecord> records = new ArrayList<MedRecord>();
    public Room(){
        
    }
    public void setRoomNo(int roomNo){
        this.roomNo = roomNo;
    }
    public int getRoomNo(){
        return this.roomNo;
    }
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
    public String getRoomType(){
        return this.roomType;
    }
    public void setRoomStatus(String roomStatus){
        this.roomStatus = roomStatus;
    }
    public String getRoomStatus(){
        return this.roomStatus;
    }
    public void setRoomCost(double roomCost){
        this.roomCost = roomCost;
    }
    public double getRoomCost(){
        return this.roomCost;
    }
    public void setRecords(MedRecord recordz){
        this.records.add(recordz);
    }
    public ArrayList<MedRecord> getRecords(){
        return this.records;
    }
    public void display() throws IOException{
        final String FILE_URL = "E:/Special Projects/JavaBTL/data.txt";
        File file = new File(FILE_URL);
        OutputStream opStream = new FileOutputStream(file);
        OutputStreamWriter opWriter = new OutputStreamWriter(opStream);
        opWriter.write("Room No: " + this.roomNo);
        opWriter.write("Room Type: " + this.roomType);
        opWriter.write("Room Status: " + this.roomStatus);
        opWriter.write("Room Cost: " + this.roomCost);
        opWriter.write("Records: ");
        for(MedRecord recordz: this.records){
            opWriter.write("Diagnosis: " + recordz.getDiagnosis());
            opWriter.write("Treatment: " + recordz.getTreatment());
            opWriter.write("Date: " + recordz.getDate());
            opWriter.write("Id: " + recordz.getId());
            opWriter.write("Cost: " + recordz.getCost());
        }
        // System.out.println("Room No: " + this.roomNo);
        // System.out.println("Room Type: " + this.roomType);
        // System.out.println("Room Status: " + this.roomStatus);
        // System.out.println("Room Cost: " + this.roomCost);
        // System.out.println("Records: ");
        // for(MedRecord recordz: this.records){
        //     System.out.println("Diagnosis: " + recordz.getDiagnosis());
        //     System.out.println("Treatment: " + recordz.getTreatment());
        //     System.out.println("Date: " + recordz.getDate());
        //     System.out.println("Id: " + recordz.getId());
        //     System.out.println("Cost: " + recordz.getCost());
        // }
    }
    public static void main(String []args){
        
    }
    
}
