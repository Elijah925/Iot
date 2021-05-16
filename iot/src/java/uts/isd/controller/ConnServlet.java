/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;

/**
 *
 * @author Taoyuan Zhu
 */
public class ConnServlet extends HttpServlet {

    private DBConnector db;
    private DBManager manager;
    private UserDAO userDAO;
    private AccessLogDAO accessLogDAO;
    private Connection conn;
    private DeviceManager deviceManager;
        
    @Override 
    public void init() {
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
        HttpSession session = request.getSession();
        conn = db.openConnection();       
        try {
            userDAO = new UserDAO(conn);
            accessLogDAO = new AccessLogDAO(conn);
            manager = new DBManager(conn);
            deviceManager = new DeviceManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        session.setAttribute("userDAO", userDAO);           
        session.setAttribute("accessLogDAO", accessLogDAO);
        session.setAttribute("manager", manager);
        session.setAttribute("deviceManager", deviceManager);
    }
    @Override
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}