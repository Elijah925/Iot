/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Staff;


/**
 *
 * @author pc
 */
public class DBManager {
    private Statement st;
    private Connection conn;
    
    public DBManager(Connection conn) throws SQLException {       
    st = conn.createStatement(); 
    this.conn = conn;
    }

    public void createStaff(String name, String email, String position, String address, Boolean status) throws SQLException {
        String columns = "INSERT INTO ELIJAH.STAFF (\"NAME\", EMAIL, \"POSITION\", ADDRESS, STATUS) ";
        String values = "VALUES('" + name + "','" + email + "','" + position + "','" + address + "','" + status + "')";
        st.executeUpdate(columns + values);
    }
    
    
    public Staff readStaff(String name, String position) throws SQLException {
        String fetch = "SELECT * FROM ELIJAH.STAFF WHERE NAME='" + name + "' AND POSITION='" + position + "'";
        ResultSet rs = st.executeQuery(fetch);
         
        while (rs.next()) {
            String staffname = rs.getString(1);
            String staffPosition = rs.getString(3);           
            
            if (staffname.equals(name) && staffPosition.equals(position)) {              
                String staffemail = rs.getString(2);
                String staffaddress = rs.getString(4);
                Boolean staffstatus = rs.getBoolean(5);
                return new Staff(staffname,staffemail,staffPosition,staffaddress,staffstatus);
                
            }
        }
      
         return null;
 
      
    }
    
    public Staff findStaff(String staffname) throws SQLException {
        String fetch = "SELECT * FROM ELIJAH.STAFF WHERE NAME='" + staffname + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            String position = rs.getString(3);
            String address = rs.getString(4);
            Boolean status = rs.getBoolean(5);
            st.close();
            return new Staff(name, email, position, address, status);            
        }
        st.close();
        return null;
    }
       
    //Update a user by ID & password
    public void updateStaff(String usertofind, String name, String email, String position, String address, Boolean status) throws SQLException {
        String query = "UPDATE ELIJAH.STAFF SET NAME=?, EMAIL=?, POSITION=?, ADDRESS=?, STATUS=? WHERE NAME = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, position);
        pstmt.setString(4, address);
        pstmt.setBoolean(5, status);
        pstmt.setString(6, usertofind);
        pstmt.executeUpdate();
        pstmt.close();
    }

    //Delete a user by ID & password
    public void deleteStaff(String name) throws SQLException {
        String delete = "DELETE FROM ELIJAH.STAFF WHERE NAME= '" + name + "'";
        st.executeUpdate(delete);
    }
    public boolean verifyStaff(String name, String position) throws SQLException {
        String fetch = "SELECT * FROM ELIJAH.STAFF WHERE NAME= '" + name + "' AND POSITION = '" + position + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String staffname = rs.getString(1);
            String staffPosition = rs.getString(3);  

            if (staffname.equals(name) && staffPosition.equals(position))
                return true;            
        }
        return false;
    }
    //Fetch all Users from the database [i.e used when displaying a table on the view]
 

    public ArrayList<Staff> fetchStaffs() throws SQLException {
        String fetch = "select * from ELIJAH.STAFF";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();

        while (rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            String position = rs.getString(3);
            String address = rs.getString(4);
            Boolean status = rs.getBoolean(5);
            temp.add(new Staff(name,email,position,address,status));
        }
        return temp;
    }

}

    