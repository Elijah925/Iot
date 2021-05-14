/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Device;
/**
 *
 * @author 47288
 */
public class DeviceManager {
    private Statement st;
    
    public DeviceManager(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    //Create product [i.e. create product as a staff]
    public void createProduct(String name,String type,String price,String stock) throws SQLException{
        String columns = "INSERT INTO ELIJAH.DEVICE (\"NAME\",\"TYPE\",PRICE,STOCK)";
        String values = "VALUES('"+name+"','"+type+"','"+price+"','"+stock+"')";
        st.executeUpdate(columns+values);
    }
    
    //Read product detail [i.e. list product records by customer or staff]
    public Device findDevice(String name,String type) throws SQLException{
        String fetch = "SELECT * FROM ELIJAH.DEVICE WHERE \"NAME\" = '"+name+"' and \"TYPE\" = '"+type+"'";
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()){
         String deviceName = rs.getString(2);
         String deviceTYPE = rs.getString(3);
         if(deviceName.equals(name) && deviceTYPE.equals(type)){
             String devicePrice= rs.getString(4);
             String deviceStock= rs.getString(5);
             return new Device(deviceName,deviceTYPE,devicePrice,deviceStock);
         }
        }
        return null;
    }
    
    //Add product [i.e. Add product as a staff ]
    public void addDevice(String name,String type,String price,String stock) throws SQLException{
        String columns = "INSERT INTO ELIJAH.DEVICE(\"NAME\",\"TYPE\",PRICE,STOCK)";
        String values = "VALUES('"+name+"','"+type+"','"+price+"','"+stock+"')";
        st.executeUpdate(columns+values);
    }
    
    //Update product [i.e. update product as a staff]
       public void updateDevice(String name,String type,String price,String stock) throws SQLException{
        st.executeLargeUpdate("UPDATE ELIJAH.DEVICE SET \"NAME\"='"+name+"',\"TYPE\"='"+type+"',PRICE='"+price+"',STOCK='"+stock+"'");
       }
    
    //Delete product [i.e. delete product as a staff]
       public void deleteDevice(String name) throws SQLException{
        st.executeUpdate("DELETE FROM ELIJAH.DEVICE WHERE \"NAME\" ='"+name+"'");
       }
       
       public ArrayList<Device> fectDevice() throws SQLException{
           String fetch ="SELECT * FROM ELIJAH.DEVICE";
           ResultSet rs = st.executeQuery(fetch);
           ArrayList<Device> temp = new ArrayList();
           
           while (rs.next()){
               String name = rs.getString(2);
               String type = rs.getString(3);
                String price= rs.getString(4);
                String stock= rs.getString(5);
               temp.add(new Device(name,type,price,stock));
           }
           return temp;
       }
       
       public boolean checkDevice(String name,String type) throws SQLException{
           String fetch ="SELECT * FROM ELIJAH.DEVICE WHERE \"NAME\" = '"+name+"' and \"TYPE\"= '"+type+"'";
           ResultSet rs = st.executeQuery(fetch);
           
           while(rs.next()){
               String deviceName = rs.getString(2);
               String deviceType = rs.getString(3);
               if (deviceName.equals(name) && deviceType.equals(type)){
                   return true;
               }
           }
           return false;
       }
}
