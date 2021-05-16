/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
         DBManager manager = (DBManager) session.getAttribute("manager");
         ArrayList<Staff> staffs = new ArrayList();
         
        try {
            staffs = manager.fetchStaffs();
            session.setAttribute("Staffs", staffs);
            request.getRequestDispatcher("ViewStaffMembers.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
