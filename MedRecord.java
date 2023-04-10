package medrecord;

import java.util.*;
import java.io.*;
import java.lang.*;
import patient.*;



public class MedRecord extends Patient{
    private String diagnosis, treatment, date;
    private int id;
    private double cost;
    public MedRecord(){
        super();
    }
    public void setAll(String Name, int age, String gender, double height, double weight, String address, String phone, String email){
        super.setName(Name);
        super.setAge(age);
        super.setGender(gender);
        super.setHeight(height);
        super.setWeight(weight);
        super.setAddress(address);
        super.setPhone(phone);
        super.setEmail(email);
    }

    public void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }
    public String getDiagnosis(){
        return this.diagnosis;
    }
    public void setTreatment(String treatment){
        this.treatment = treatment;
    }
    public String getTreatment(){
        return this.treatment;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public double getCost(){
        return this.cost;
    }
    public void display() throws IOException{
        super.display();
        final String FILE_URL = "E:/Special Projects/JavaBTL/data.txt";
        File file = new File(FILE_URL);
        OutputStream opStream = new FileOutputStream(file);
        OutputStreamWriter opWriter = new OutputStreamWriter(opStream);
        opWriter.write("Diagnosis: " + this.diagnosis);
        opWriter.write("Treatment: " + this.treatment);
        opWriter.write("Date: " + this.date);
        opWriter.write("Id: " + this.id);
        opWriter.write("Cost: " + this.cost);

    }
    public static void main(String []args){

    }    
}
