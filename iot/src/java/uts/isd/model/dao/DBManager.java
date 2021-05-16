/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Taoyuan Zhu
 */
public class DBManager {
    private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
  }


public boolean checkUser(int userid,String password) throws SQLException{
    String fetch = "select * from Elijah.user_t where USERID= '"+ userid +"' and PASSWORD = '" + password + "'";      
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()){
        int uid = rs.getInt(1);
        String userpass = rs.getString(5);
        if(uid == userid && userpass.equals(password))
            return true;
    }
       return false;
}



}
