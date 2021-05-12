package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Payment implements Serializable {
    private int PaymentID;
    private int OrderID;
    private String PaymentMethod;
    private String cardnumber;
    private int amount;
    private String date;
    
    public Payment(){}

    public Payment(int OrderID, String PaymentMethod,String cardnumber,int amount, String date) {
        this.OrderID = OrderID;
        this.PaymentMethod = PaymentMethod;
        this.cardnumber = cardnumber;
        this.amount = amount;
        this.date = date;
    
    }
    
    public Payment(int PaymentID, int OrderID, String PaymentMethod,String cardnumber,int amount, String date) {
        this.PaymentID = PaymentID;
        this.OrderID = OrderID;
        this.PaymentMethod = PaymentMethod;
        this.cardnumber = cardnumber;
        this.amount = amount;
        this.date = date;
    }

    public void updateInfo(int OrderID, String PaymentMethod,String cardnumber,int amount, String date) {
        this.OrderID = OrderID;
        this.PaymentMethod = PaymentMethod;
        this.cardnumber = cardnumber;
        this.amount = amount;
        this.date = date;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    


}