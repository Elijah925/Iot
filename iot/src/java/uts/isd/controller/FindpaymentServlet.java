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
import uts.isd.model.Payment;
import uts.isd.model.dao.PaymentManager;

/**
 *
 * @author lenovo
 */
public class FindpaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int id = Integer.parseInt(request.getParameter("PaymentID"));
        String date = request.getParameter("date");
        PaymentManager paymentManager = (PaymentManager) session.getAttribute("paymentManager");
        Payment payment = null;
        validator.clear(session);
        
        if(!validator.validateDate(date)){
            session.setAttribute("dateErr","Date format incorrect");
            request.getRequestDispatcher("findpayment.jsp").include(request, response);
            
        }else{
            try{
                payment = paymentManager.readPayment(id,date);
                if(payment != null){
                    session.setAttribute("payment", payment);
                    request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
                }else{
                    session.setAttribute("ExistErr","Payment does not exist in the Database");
                    request.getRequestDispatcher("findpayment.jsp").include(request, response);
                }
            }catch(SQLException | NullPointerException ex){
               // Logger.getLogger(FindpaymentServlet.class.getName()).log(Level.SEVERE, null, ex);     
                System.out.println(ex.getMessage()== null ? "Payment does not exist":"exist");
            }
        
        }
        
    }
}
