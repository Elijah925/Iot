<%-- 
    Document   : viewsearchpayment
    Created on : 2021-5-11, 23:49:08
    Author     : lenovo
--%>

<%@page import="uts.isd.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/index.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="nav">
              <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
              <span id="links"> <a href="payment.jsp" style="text-decoration:none;"> Paymentlist</a> | <a href="logout.jsp" style="text-decoration:none;">Logout </a></span>
           
        </div>
        <hr style="margin-top: 25px;"/>
        <div class="wholecontent">
             <%
                 Payment payment = (Payment) session.getAttribute("payment"); 
                String existErr = (String) session.getAttribute("existErr");
                String dateErr = (String) session.getAttribute("dateErr");
                String resultInfor = (String) session.getAttribute("resultInfor");
            %>
            <h2>Update a Payment</h2><small><%=(resultInfor != null ? resultInfor : "")%></small>
            
                <form id="form" action="UpdatepaymentServlet"  method="post">
                <table id="table">
                    <tr><td>PaymentID:<input type="text" placeholder="<%=payment.getPaymentID()%>" name="PaymentID" required="true"></td></tr>
                    <tr><td>OrderID:<input type="text" placeholder="<%=payment.getOrderID()%>" name="orderid" required="true"></td></tr>
                    <tr><td>Payment Method:<input type="text" placeholder="<%=payment.getPaymentMethod()%>"name="paymentmethod"></td></tr>
                    <tr><td>Card Number:<input type="text" placeholder="<%=payment.getCardnumber()%>" name="cardnumber" required="true"></td></tr>
                    <tr><td>Amount:<input type = "text" placeholder="<%=payment.getAmount()%>"  name="amount" required="true"/></td></tr>
                    <tr><td>Date:<input type="text" placeholder="<%=payment.getDate()%>" name="date"/> </td></tr>
                 
                </table>
                <div>
                    <a href="index.jsp">Cancle</a>  
                    <input class="button" type="submit" value="Update">
                </div>
                    
                    
            </form>
                     <h2>Delete a Payment</h2><small><%=(resultInfor != null ? resultInfor : "")%></small>
            <span class="message">
                <%=(existErr != null ? existErr : "")%>
            </span>
                     <form id="form" action="DeletepaymentServlet"  method="post">
                <table id="table">
                    <tr><td>PaymentID:<input type="text" placeholder="<%=payment.getPaymentID()%>" name="PaymentID" required="true"></td></tr>
                    
                    <tr><td>Date:<input type="text" placeholder="<%=payment.getDate()%>" name="date"/> </td></tr>
                 
                </table>
                <div>
                    <a href="index.jsp">Cancle</a>  
                    <input class="button" type="submit" value="Delete">
                </div>
            </form>
        </div>
    </body>
</html>
