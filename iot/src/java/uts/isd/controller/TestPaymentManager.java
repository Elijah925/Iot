/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import uts.isd.model.Payment;
import uts.isd.model.dao.*;

/**
 *
 * @author lenovo
 */
public class TestPaymentManager {
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestPaymentManager().menu();
    }
    private DBConnector connector;
    private Connection conn;
    private PaymentManager manager;
    
    public TestPaymentManager() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        manager = new PaymentManager(conn);
    }
    
    private void testCreate() throws SQLException {
        int orderid = Integer.parseInt(read("orderid"));
        int amount = Integer.parseInt(read("amount"));
        System.out.println("Adding payment to the database: ");
        manager.createPayment(orderid, read("PaymentMethod"), read("cardnumber"), amount, read("date"));
        System.out.println("Payment added successfully ");
    }
    
    private void testRead() throws SQLException{
        int ID = Integer.parseInt(read("ID"));
        String date = read("DATE");
        Payment payment = manager.readPayment(ID, date);
        String exist = (payment != null) ? "Payment exists in the database" : "Payment does not exist!!!";
        System.out.println(exist);
    }

    private void testUpdate() throws SQLException{
        int paymentID = Integer.parseInt(read("paymentID"));
        int orderid = Integer.parseInt(read("orderid"));
        int amount = Integer.parseInt(read("amount"));
        String date = read("DATE");
        manager.updatePayment(paymentID, orderid, read("PaymentMethod"),read("cardnumber"), amount,date);
        System.out.println("Payment details updated successfully ");
    }
    
    private void testDelete() throws SQLException{
        int ID = Integer.parseInt(read("ID"));
        manager.deletePayment(ID);
        System.out.println("Payment deleted successfully");
    }
    
    private void testFetch() throws SQLException{
        PrintStream printf = System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n","paymentID","orderid", "paymentMethod", "cardnumber", "amount", "paymentdate");
        ArrayList<Payment> payments = manager.fecthPayments();
        payments.forEach(payment->System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n"
                + "",payment.getPaymentID(),payment.getOrderID(),payment.getPaymentMethod(),payment.getCardnumber(),payment.getAmount(),payment.getDate()));
        System.out.println();
    }
    
    private String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
    private void menu() throws SQLException{
        char c;
        help();
        while((c=read("Command [c/r/u/d/f/x]").charAt(0)) != 'x'){
            switch(c){
                case 'c': testCreate();break;
                case 'r': testRead(); break;
                case 'u': testUpdate(); break;
                case 'd': testDelete();break;
                case 'f': testFetch();break;
                default: help(); break;
            }
        }
    }
    private void help(){
        System.out.println("Database Operations: \n"
                + "c = Create Payment \n"
                + "r = Read Payment by paymentID-date \n"
                + "u = Update Payment by paymentID \n"
                + "d = Delete Payment by paymentID\n"
                + "f = Fetch all Payments\n");
    }
}
