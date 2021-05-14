package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Device implements Serializable {
    private int ID;
    private String name;
    private String type;
    private String price;
    private String stock;
   
    
    public Device(){}

    public Device(String name, String type, String price, String stock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
        
    }
    
    public Device(int ID, String name,  String type, String price, String stock) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public void updateInfo(String name, String type, String price, String stock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    
    
    
    
    
}

