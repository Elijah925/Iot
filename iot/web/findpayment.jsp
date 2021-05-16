<%-- 
    Document   : findpayment
    Created on : 2021-5-11, 16:39:00
    Author     : lenovo
--%>

<%@page import="uts.isd.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/login.css">
        <title>Findpayment Page</title>
    </head>
    <body>
       <div class="nav">
              <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
              <span id="links"> <a href="payment.jsp" style="text-decoration:none;"> Back</a> | <a href="logout.jsp" style="text-decoration:none;">Logout </a></span>
           
        </div>
        <hr style="margin-top: 25px;"/>
       
        
        <div class="wholecontent">
             
        <%
            String existErr = (String) session.getAttribute("existErr");
            String dateErr = (String) session.getAttribute("dateErr");
           
        %>
            <h1>Search for payment<span class="message"><%=(existErr != null ? existErr : "")%></span></h1>
            <form id="form" action="FindpaymentServlet" method="post">
                <table id="table">
                      <tr><td><input type="text" placeholder="Enter the paymentID" name="PaymentID" required="true"></td></tr>
                      <tr><td><input type="text" placeholder="<%=(dateErr != null ? dateErr:"Enter the paymentdate")%>" name="date" required="true"></td></tr>
                      
                </table>           
                <div>
                    <input class="button" type="submit" value="Search">
                </div>
            </form>
        
        </div>
              
    </body>
</html>
