
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Staff implements Serializable {
    private int ID;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private String dob;
    private String position;
    private String address;
    
    public Staff(){}

    public Staff(String name, String email, String password, String phone, String gender, String dob,String position, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.position = position;
        this.address = address;
    }
    
    public Staff(int ID, String name, String email, String password, String phone, String gender, String dob,String position, String address) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.position = position;
        this.address = address;
    }

    public void updateInfo(String name, String email, String password, String phone, String gender, String dob, String position, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;     
        this.position = position;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
}
