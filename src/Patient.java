import java.io.Serializable;


public class Patient implements Serializable {
    static int count = 0;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private String address;

    public Patient() {
        this.id = ++count;
    }

    public Patient(String name, String gender, int age, String email, String phone, String address) {
        this.id = ++count;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Patient(int id, String name, int age, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        count = Math.max(count, id);
    }

    public String toString() {
        return String.format("%04d\t%-20s\t%3d\t%-30s\t%-12s\t%-20s", this.id, this.name, this.age, this.email, this.phone,
                this.address);
    }

    static String getHeader() {
        return String.format("%-4s\t%-20s\t%-3s\t%-30s\t%-12s\t%-20s", "ID", "Name", "Age", "Email", "Phone", "Address");
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

    public String getGender(){
        return String.format("%s", this.gender);
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    public String getEmail() {
        return String.format("%s", this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return String.format("%s", this.phone);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return String.format("%s", this.address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object[] toObjects(){
        return new Object[]{getId(), getName(), getGender(), getAge(), getEmail(), getPhone(), getAddress()};
    }
}
