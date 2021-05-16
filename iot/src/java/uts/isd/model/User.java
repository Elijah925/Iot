
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author Taoyuan Zhu
 */
public class User implements Serializable {
    private int ID;
    private String name;
    private String userEmail;
    private String password;
    private String phone;
    private Boolean isStaff;
    
    public User(){}

    public User(String name, String email, String password, String phone, Boolean isStaff) {
        this.name = name;
        this.userEmail = email;
        this.password = password;
        this.phone = phone;
        this.isStaff = isStaff;
    }
    
    public User(int ID, String name, String email, String password, String phone, Boolean isStaff) {
        this.ID = ID;
        this.name = name;
        this.userEmail = email;
        this.password = password;
        this.phone = phone;
        this.isStaff = isStaff;
    }

    public void updateInfo(String name, String email, String password, String phone, Boolean isStaff) {
        this.name = name;
        this.userEmail = email;
        this.password = password;
        this.phone = phone; 
        this.isStaff = isStaff;
    }

    public int getUserID() {
        return ID;
    }

    public void setUserID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
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
    
    public Boolean getIsStaff() {
        return isStaff;
    }
    
    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }
}