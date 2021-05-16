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
public class UpdatepaymentServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int PaymentID = Integer.parseInt(request.getParameter("PaymentID"));
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        String date = request.getParameter("date");
        String paymentmethod = request.getParameter("paymentmethod");
        String cardnumber = request.getParameter("cardnumber");
        int amount = Integer.parseInt(request.getParameter("amount"));
        PaymentManager paymentManager = (PaymentManager) session.getAttribute("paymentManager");
      
       
     
        Validator validator = new Validator();
        validator.clear(session);
         if(!validator.validateDate(date)){
            session.setAttribute("dateErr","Date format incorrect");
            request.getRequestDispatcher("findpayment.jsp").include(request, response);
            
        }else{
        try{
                Payment payment = new Payment(PaymentID,orderid,paymentmethod,cardnumber,amount,date);
                if (payment != null) {
                session.setAttribute("payment", payment);
                paymentManager.updatePayment(PaymentID,orderid,paymentmethod,cardnumber,amount,date);
                session.setAttribute("resultInfor", "Update was successful");
                request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
            } else {
                session.setAttribute("resultInfor", "Update was not successful!");
                request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
            }
           
        }catch (SQLException ex){
            Logger.getLogger(UpdatepaymentServlet.class.getName()).log(Level.SEVERE, null, ex); 
            
         }     
     
      }
    }
}
