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
    private int price;
    private int stock;
   
    
    public Device(){}

    public Device(String name, String type, int price, int stock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
        
    }
    
    public Device(int ID, String name,  String type, int price, int stock) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public void updateInfo(String name, String type, int price, int stock) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    
    
}

