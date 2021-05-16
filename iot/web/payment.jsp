<%-- 
    Document   : payment
    Created on : 2021-5-11, 0:51:30
    Author     : lenovo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.dao.PaymentManager"%>
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
              <span id="links"> <a href="index.jsp" style="text-decoration:none;"> Back</a> | <a href="logout.jsp" style="text-decoration:none;">Logout </a></span>
           
        </div>
        <hr style="margin-top: 25px;"/>
        <div class="wholecontent">
          
              <%
                PaymentManager paymentManager =(PaymentManager)session.getAttribute("paymentManager");
                ArrayList<Payment> list = paymentManager.fecthPayments();
                 String resultInfor = (String) session.getAttribute("resultInfor");
              %>
            <center>
                <h1>Payment Management</h1>
                <h2>
                    <a href="addpayment.jsp">Create New Payment</a>
                 
                    &nbsp;&nbsp;&nbsp;
                    <a href="findpayment.jsp">Find a Payment</a>
             
                </h2>
            </center>
            
            <table border="1" cellpadding="5" align="center">
                <caption><h2>List of Payments</h2></caption><small><%=(resultInfor != null ? resultInfor : "")%></small>
                <tr>
                    <th>PaymentID</th>
                    <th>OrderID</th>
                    <th>PaymentMethod</th>
                    <th>CardNumber</th>
                    <th>Amount</th>
                    <th>Date</th>
                   
                    
                </tr>
             
               <%
                   for(Payment payment : list){
               %>
                    <tr>
                        
                        <td><%=payment.getPaymentID()%></td>
                        <td><%=payment.getOrderID()%></td>
                        <td><%=payment.getPaymentMethod()%></td>
                        <td><%=payment.getCardnumber()%></td>
                        <td><%=payment.getAmount()%></td>
                        <td><%=payment.getDate()%></td>
                       
                    </tr>
                   <%}%>
            
            </table>
               
        </div> 
             <jsp:include page="/ConnServlet" flush="true" />
             
    </body>
</html>
