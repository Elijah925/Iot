/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.isd.model.User;

/**
 *
 * @author Taoyuan Zhu
 */
public class UserDAO {
    private Statement st;
    private Connection conn;
    
    public UserDAO (Connection conn) throws SQLException {
        st = conn.createStatement();
        this.conn = conn;
    }
    
  
    public void addUser(String userEmail, String userName, String password, String phoneNumber) throws SQLException {
        String query = "INSERT INTO Elijah.USER_T(UserEmail, UserName, Password, PhoneNumber, IsStaff) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userEmail);
            pstmt.setString(2, userName);
            pstmt.setString(3, password);
            pstmt.setString(4, phoneNumber);
            pstmt.setBoolean(5, false);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public User findUser(String userEmail) throws SQLException {
        String fetch = "SELECT * FROM Elijah.USER_T WHERE USEREMAIL=?";
        PreparedStatement pstmt = conn.prepareStatement(fetch);
        pstmt.setString(1, userEmail);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            int id = rs.getInt(1);
            String email = rs.getString(2);
            String name = rs.getString(3);
            String password = rs.getString(4);
            String phoneNumber = rs.getString(5);            
            Boolean isStaff = rs.getBoolean(6);
            pstmt.close();
            return new User(id, email, name, password, phoneNumber, isStaff);            
        }
        pstmt.close();
        return null;
    }
    
  
    public void updateUser(int id, String userEmail, String userName, String password, String phoneNumber) throws SQLException {        
        String query = "UPDATE Elijah.USER_T SET UserEmail=?, UserName=?, Password=?, PhoneNumber=?, isStaff=? WHERE UserId = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, userEmail);
        pstmt.setString(2, userName);
        pstmt.setString(3, password);
        pstmt.setString(4, phoneNumber);
        pstmt.setBoolean(5, false);
        pstmt.setInt(6, id);
        pstmt.executeUpdate();
        pstmt.close();
    }
    

    public void deleteUser(int userID) throws SQLException {
        String query = "DELETE FROM Elijah.USER_T WHERE UserID=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, userID);
        pstmt.executeUpdate();
        pstmt.close();
    }
    

    public boolean checkUser(String userEmail) throws SQLException {
        String query = "SELECT * FROM Elijah.USER_T WHERE USEREMAIL=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, userEmail);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            String email = rs.getString(1);           
            if (userEmail.equals(email)) {
                pstmt.close();
                return true;
            }
        }        
        return false;
    }
    

    public ArrayList<User> ShowUser() throws SQLException{
        String query = "SELECT * FROM Elijah.USER_T ORDER BY UserID";
        ArrayList<User> UserList = new ArrayList<User>();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            User user = new User(rs.getInt("UserID"), rs.getString("UserEmail"), rs.getString("UserName"), rs.getString("Password"), rs.getString("PhoneNumber"), rs.getBoolean("isStaff"));
            UserList.add(user);
        } 
        
        return UserList;
    }
}