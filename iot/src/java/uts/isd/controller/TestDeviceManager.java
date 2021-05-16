
package uts.isd.controller;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Device;
import uts.isd.model.dao.*;
public class TestDeviceManager {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DeviceManager db;
    
    public static void main (String [] agrs) throws ClassNotFoundException, SQLException{
        (new TestDeviceManager()).runQueries();
    }
    
    public TestDeviceManager() throws ClassNotFoundException, SQLException{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DeviceManager(conn);
    }
    
    private char readChoice(){
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException{
        char c  ;
        while((c= readChoice())!='*'){
            switch (c){
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;    
                case 'S':
                    showAll();
                    break; 
                default: System.out.println("Unknow Command");
            }
        }
    }

    private void testAdd() throws SQLException {
        System.out.print("Device name: ");
        String name = in.nextLine();
        System.out.print("Device type: ");
        String type = in.nextLine();
        System.out.print("Device price: ");
        String price = in.nextLine();
        System.out.print("Device stock: ");
        String stock = in.nextLine();
        db.addDevice(name, type, price, stock);
        System.out.println("Device is add to the databse.");
    }
    
    private void testRead() throws SQLException{
        System.out.print("Device name: ");
        String name = in.nextLine();
        System.out.print("Device type: ");
        String type = in.nextLine();
        Device device = db.findDevice(name, type);
        if(device != null ){
            System.out.println("Device " + device.getName() + " exists in the database.");
        }
        else{
            System.out.println("Device does not exists.");
        }
    }
    
    public void testUpdate() throws SQLException{
        System.out.print("Device name: ");
        String name = in.nextLine();
        System.out.print("Device type: ");
        String type = in.nextLine();
        
        if(db.checkDevice(name, type)){
            System.out.print("Device name: ");
            name = in.nextLine();
            System.out.print("Device type: ");
             type = in.nextLine();
            System.out.print("Device price: ");
            String price = in.nextLine();
            System.out.print("Device stock: ");
            String stock = in.nextLine();
            db.updateDevice(name, type, price, stock);
        }
        else{System.out.println("Device does not exists.");}
    }
    
    public void testDelete() throws SQLException{
        System.out.print("Device name: ");
        String name = in.nextLine();
        System.out.print("Device type: ");
        String type = in.nextLine();
        if(db.checkDevice(name, type)){
            db.deleteDevice(name,type);
        }
        else{System.out.println("Device does not exists.");}
    }
    
    public void showAll() throws SQLException{
        ArrayList<Device> devices = db.fectDevice();
        System.out.println("Device table: ");
        devices.stream().forEach((device) -> {System.out.printf("%-35s %-30s %-20s %-10s \n",device.getName(),device.getType(),device.getPrice(),device.getStock());
                });
        System.out.println();
    }
    
}
