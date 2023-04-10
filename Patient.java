package patient;

import java.util.*;
import java.io.*;
import java.lang.*;


public class Patient{
    private String name, gender, address, phone, email;
    private int age;
    private double weight, height;

    public Patient(){

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public int getAge(){
        return this.age;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return this.weight;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void display() throws IOException{
        final String FILE_URL = "E:/Special Projects/JavaBTL/data.txt";
        File file = new File(FILE_URL);
        OutputStream opStream = new FileOutputStream(file);
        OutputStreamWriter opWriter = new OutputStreamWriter(opStream);
        opWriter.write("Patient Information"); 
        opWriter.write("Name: " + this.name);
        opWriter.write("Age: " + this.age);
        opWriter.write("Gender: " + this.gender);
        opWriter.write("Height: " + this.height);
        opWriter.write("Weight: " + this.weight);
        opWriter.write("Address: " + this.address);
        opWriter.write("Phone: " + this.phone);
        opWriter.write("Email: " + this.email);

    }
    public static void main(String[] args){
        
    }

}