package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Order implements Serializable {
    private int OrderID;
    private int DeviceID;
    private int UserID;
    private int PaymentID;
    private String date;
    private String deliveryDate;
    private String deliveryWay;
   
    
    public Order(){}

    public Order(int DeviceID,int UserID,int PaymentID, String date, String deliveryDate, String deliveryWay) {
        this.DeviceID = DeviceID;
        this.UserID = UserID;
        this.PaymentID = PaymentID;
        this.date = date;
        this.deliveryDate = deliveryDate;
        this.deliveryWay = deliveryWay;
        
    }
    
    public Order(int OrderID, int DeviceID,int UserID,int PaymentID, String date, String deliveryDate, String deliveryWay) {
        this.OrderID = OrderID;
        this.DeviceID = DeviceID;
        this.UserID = UserID;
        this.PaymentID = PaymentID;
        this.date = date;
        this.deliveryDate = deliveryDate;
        this.deliveryWay = deliveryWay;
    }

    public void updateInfo(int DeviceID,int UserID,int PaymentID, String date, String deliveryDate, String deliveryWay) {
        this.DeviceID = DeviceID;
        this.UserID = UserID;
        this.PaymentID = PaymentID;
        this.date = date;
        this.deliveryDate = deliveryDate;
        this.deliveryWay = deliveryWay;
        
    }
    

}