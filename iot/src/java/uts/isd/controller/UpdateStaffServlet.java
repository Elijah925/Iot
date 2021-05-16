/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author pc
 */
public class UpdateStaffServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String usertofind = request.getParameter("usertofind");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String address = request.getParameter("address");
        Boolean status = (request.getParameter("status") != null);
        
        DBManager manager = (DBManager) session.getAttribute("manager");        

        try {
            manager.updateStaff(usertofind,name,email,position,address,status);
            session.setAttribute("edited",name+" has been successfully edited");
            request.getRequestDispatcher("SuccessfulNotification.jsp").include(request, response);
        } catch (SQLException ex) {
           Logger.getLogger(UpdateStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        }
}
