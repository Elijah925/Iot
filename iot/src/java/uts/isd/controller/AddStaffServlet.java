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
public class AddStaffServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Validator validator = new Validator();  
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String address = request.getParameter("address");
        Boolean status = (request.getParameter("status") != null);
        
        DBManager manager = (DBManager) session.getAttribute("manager");        
        validator.clear(session);

            if(!validator.validateEmail(email)){
                session.setAttribute("emailErr", "Error: Email format is incorrect");
                request.getRequestDispatcher("CreateStaffRecords.jsp").include(request, response);
            }else if(!validator.validateName(name)){
                session.setAttribute("nameErr", "Error: Name format is incorrect");
                request.getRequestDispatcher("CreateStaffRecords.jsp").include(request, response);
            } else if (!validator.validatePosition(position)) {
                session.setAttribute("positionErr", "Error: Position format is incorrect");
                request.getRequestDispatcher("CreateStaffRecords.jsp").include(request, response);
            } else {
            try {
                Staff exist = manager.readStaff(name, position);
                if (exist != null) {
                session.setAttribute("existErr", " already exists in the Database!");
                request.getRequestDispatcher("CreateStaffRecords.jsp").include(request, response);
            }else{
                manager.createStaff(name, email, position, address, status);
                Staff staff = new Staff(name, email, position, address, status);
                session.setAttribute("Staff", staff);
                session.setAttribute("created",name+" has been successfully created");
                request.getRequestDispatcher("ViewStaffMembers.jsp").include(request, response);
      
            }
            } catch (SQLException ex) {
               Logger.getLogger(AddStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }   

        }
}
