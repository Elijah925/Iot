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
public class findStaffServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(); 
        String name = request.getParameter("name");
        String position = request.getParameter("position");
        
        DBManager manager = (DBManager) session.getAttribute("manager");        

        try {
            Staff staff = manager.readStaff(name, position);
            if (staff != null) {
                session.setAttribute("stafftofind", staff);
                request.getRequestDispatcher("ViewStaffMembers.jsp").include(request, response);
            }else{
                session.setAttribute("stafftofind", null);
                request.getRequestDispatcher("ViewStaffMembers.jsp").include(request, response);
            }
        } catch (SQLException ex) {
           Logger.getLogger(findStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   

        }
}
