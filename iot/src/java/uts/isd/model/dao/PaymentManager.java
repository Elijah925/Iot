
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Payment;


/**
 *
 * @author lenovo
 */
public class PaymentManager {
    private Statement st;
    ArrayList<Payment> temp = new ArrayList();
    public PaymentManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    //Create a Payment
    public void createPayment(int OrderID, String PaymentMethod,String cardnumber,int amount, String date) throws SQLException{
        String columns = "INSERT INTO ELIJAH.PAYMENT(ORDERID,PAYMENTMETHOD,CARDNUMBER,AMOUNT,\"DATE\")";
        String values = "VALUES("+OrderID+",'"+PaymentMethod+"','"+cardnumber+"',"+amount+",'"+date+"')";
        st.executeUpdate(columns+values);
    }
    //Read Payment by paymentID and date
     public Payment readPayment(int PaymentID, String date) throws SQLException {
        String fetch = "SELECT * FROM ELIJAH.PAYMENT WHERE PAYMENTID=" + PaymentID + " AND DATE='" + date + "'";//read from where paymentID = and date = 

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int paymentID = Integer.parseInt(rs.getString(1));
            String paymentdate = rs.getString(6);

            if (paymentID == PaymentID && paymentdate.equals(date)) {
                int orderid = Integer.parseInt(rs.getString(2));
                String paymentMethod = rs.getString(3);
                String cardnumber = rs.getString(4);
                int amount = Integer.parseInt(rs.getString(5));

                return new Payment(paymentID, orderid, paymentMethod, cardnumber, amount, paymentdate);
            }
        }
        return null;
    }
     
     public  Payment getRecordById(int PaymentID){  
         try{
    
        String getp = "SELECT * FROM ELIJAH.PAYMENT WHERE PAYMENTID=" + PaymentID + "";
  
        ResultSet rs=st.executeQuery(getp);  
        while(rs.next()){  
           
            int paymentID = Integer.parseInt(rs.getString(1));
            if (paymentID == PaymentID) {
                int orderid = Integer.parseInt(rs.getString(2));
                String paymentMethod = rs.getString(3);
                String cardnumber = rs.getString(4);
                int amount = Integer.parseInt(rs.getString(5));
                String paymentdate = rs.getString(6);
                return new Payment(paymentID, orderid, paymentMethod, cardnumber, amount, paymentdate);
            }  
        }
         }catch(Exception e){System.out.println(e);}  
         return null;
}  
     
     
    //Update payment by paymentID and date
    public void updatePayment(int PaymentID, int OrderID, String PaymentMethod,String cardnumber,int amount, String date) throws SQLException {
        String update = "UPDATE ELIJAH.PAYMENT SET PAYMENTMETHOD='" + PaymentMethod + "',CARDNUMBER='" + cardnumber + "', AMOUNT="+amount+" WHERE PAYMENTID=" + PaymentID + " AND DATE='" + date + "'";
        st.executeUpdate(update);
    }
    //delete payment by paymentID
    public void deletePayment(int ID) throws SQLException {
        String delete = "DELETE FROM ELIJAH.PAYMENT WHERE PAYMENTID=" + ID + "";
        st.executeUpdate(delete);
    }
    
     //Fetch all Payments from the database [i.e used when displaying a table on the view]
    public ArrayList<Payment> fecthPayments() throws SQLException {
        String fetch = "select * from ELIJAH.PAYMENT";
        ResultSet rs = st.executeQuery(fetch);
        

        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            int orderid = Integer.parseInt(rs.getString(2));
            String paymentMethod = rs.getString(3);
            String cardnumber = rs.getString(4);
            int amount = Integer.parseInt(rs.getString(5));
            String paymentdate = rs.getString(6);
            temp.add(new Payment(ID,orderid,paymentMethod,cardnumber,amount,paymentdate));
        }
        return temp;
    }
    
    public boolean checkPayment(int PaymentID) throws SQLException{
           String fetch ="SELECT * FROM ELIJAH.PAYMENT WHERE PAYMENTID=" + PaymentID + "";
           ResultSet rs = st.executeQuery(fetch);
           
           while(rs.next()){
               int ID = Integer.parseInt(rs.getString(1));
              
               if (ID == PaymentID){
                   return true;
               }
           }
           return false;
       }
    
}
