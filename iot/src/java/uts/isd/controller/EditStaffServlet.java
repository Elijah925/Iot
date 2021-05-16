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
import uts.isd.model.Staff;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author pc
 */
public class EditStaffServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(); 
        String name = request.getParameter("name");
        
        DBManager manager = (DBManager) session.getAttribute("manager");        


   
        try {
            Staff staff = manager.findStaff(name);
            if (staff != null) {
                session.setAttribute("StaffToEdit", staff);
                request.getRequestDispatcher("EditStaffDetails.jsp").include(request, response);
            }else{
                session.setAttribute("StaffToEdit", null);
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        } catch (SQLException ex) {
           Logger.getLogger(EditStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   

        }
}
