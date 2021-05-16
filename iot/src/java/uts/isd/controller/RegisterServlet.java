/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author Taoyuan Zhu
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getRequestDispatcher("register.jsp").include(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession();      
        String name = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String phoneNumber = request.getParameter("phone").trim();  
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");        
    
        try {
            User user = userDAO.findUser(email);
            if (user != null) {
                session.setAttribute("existErr", "Error: This email already exists in the system");
                request.getRequestDispatcher("register.jsp").include(request, response);            
            } else if (!phoneNumber.isEmpty()) {
                        try {
                            userDAO.addUser(email, name, password, phoneNumber);
                            request.getRequestDispatcher("registerSuccess.jsp").include(request, response);                
                        } catch (SQLException ex) {
                            session.setAttribute("addErr", "Error: User was not added to the database");
                            request.getRequestDispatcher("register.jsp").include(request, response);
                        }
                                
            } else {
                try {
                    userDAO.addUser(email, name, password, phoneNumber);
                    request.getRequestDispatcher("registerSuccess.jsp").include(request, response);                
                } catch (SQLException ex) {
                    session.setAttribute("addErr", "Error: User was not added to the database");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
