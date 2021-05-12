package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Supplier implements Serializable {
    private int ID;
    private String name;
    private String email;
    private String company;
    private String phone;
  
    
    public Supplier(){}

    public Supplier(String name, String email, String company, String phone) {
        this.name = name;
        this.email = email;
        this.company = company;
        this.phone = phone;
       
    }
    
    public Supplier(int ID, String name, String email,String company, String phone) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.company = company;
        this.phone = phone;
    }

    public void updateInfo(String name, String email,String company, String phone) {
        this.name = name;
        this.email = email;
        this.company = company;
        this.phone = phone; 
    }
}