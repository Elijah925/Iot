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
import uts.isd.model.dao.PaymentManager;

/**
 *
 * @author lenovo
 */
public class DeletepaymentServlet extends HttpServlet {
 
   
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         int PaymentID = Integer.parseInt(request.getParameter("PaymentID"));
         PaymentManager paymentManager = (PaymentManager)session.getAttribute("paymentManager");
       
        try{
             
                    paymentManager.deletePayment(PaymentID);
                    session.setAttribute("resultInfor", "Delete payment was successful!");
                    request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
               
        }catch(SQLException ex){
          Logger.getLogger(DeletepaymentServlet.class.getName()).log(Level.SEVERE, null, ex);     
        }
    

     }
}
