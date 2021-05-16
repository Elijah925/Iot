<%-- 
    Document   : addpayment
    Created on : 2021-5-11, 18:33:09
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css">
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
            String existErr = (String) session.getAttribute("existErr");
            String dateErr = (String) session.getAttribute("dateErr");
            
            %>
            <h2>Add a Payment</h2>
            <span class="message">
                <%=(existErr != null ? existErr : "")%>
            </span>
                <form id="form" action="AddpaymentServlet"  method="post">
                <table id="table">

                    <tr><td><input type="text" placeholder="Enter your Orderid" name="orderid" required="true"></td></tr>
                    <tr><td><input type="text" placeholder="Enter your PaymentMethod" name="paymentmethod" required="true"></td></tr>
                    <tr><td><input type="text" placeholder="Enter your cardnumber" name="cardnumber" required="true"></td></tr>
                    <tr><td><input type = "text" placeholder="Enter your amount"  name="amount" required="true"/></td></tr>
                    <tr><td><input type="text" placeholder="<%=(dateErr != null ? dateErr:"Enter the date")%>" name="date"/> </td></tr>
                    

                </table>
                <div>
                    <a href="index.jsp">Cancle</a>  
                    <input class="button" type="submit" value="Add">
                </div>
            </form>
        </div>
    </body>
</html>
