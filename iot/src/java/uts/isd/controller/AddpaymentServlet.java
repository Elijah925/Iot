
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
public class AddpaymentServlet extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        String date = request.getParameter("date");
        String paymentmethod = request.getParameter("paymentmethod");
        String cardnumber = request.getParameter("cardnumber");
        int amount = Integer.parseInt(request.getParameter("amount"));
 
        PaymentManager paymentManager = (PaymentManager) session.getAttribute("paymentManager");
        validator.clear(session);
        
        if(!validator.validateDate(date)){
            session.setAttribute("dateErr","Date format incorrect");
            request.getRequestDispatcher("addpayment.jsp").include(request, response);
            
        }else{
            try{
                Payment exist = paymentManager.readPayment(orderid,date);
                if(exist != null){
                    session.setAttribute("existErr", "Payment already exists in the Database!");
                    request.getRequestDispatcher("addpayment.jsp").include(request, response);
                }else{
                    paymentManager.createPayment(orderid,paymentmethod,cardnumber,amount,date);
                    Payment payment = new Payment(orderid,paymentmethod,cardnumber,amount,date);
                    session.setAttribute("Payment",payment);
                    session.setAttribute("resultInfor", "Add was successful");
                    request.getRequestDispatcher("payment.jsp").include(request, response);
               
                }
            }catch(SQLException ex){
                Logger.getLogger(FindpaymentServlet.class.getName()).log(Level.SEVERE, null, ex);     
                //System.out.println(ex.getMessage()== null ? "Payment does not exist":"exist");
            }
        }
       
        
    }
}
