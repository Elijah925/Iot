
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
    private String position;
    private String address;
    private Boolean status;
    
    public Staff(){}

    public Staff(String name, String email,String position, String address, Boolean status) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.address = address;
        this.status = status;
    }
    
    public Staff(int ID, String name, String email,String position, String address, Boolean status) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.position = position;
        this.address = address;
        this.status = status;
    }


    public void updateInfo(String name, String email, String position, String address, Boolean status) {
        this.name = name;
        this.email = email;   
        this.position = position;
        this.address = address;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean stauts) {
        this.status = status;
    }  

}
