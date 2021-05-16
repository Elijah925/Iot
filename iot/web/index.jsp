<%-- 
    Document   : index
    Created on : 2021-4-13, 22:13:41
    Author     : Taoyuan Zhu
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css">
        <title>Interface</title>
        <%
            User user = (User) session.getAttribute("user");
        %>
    </head>

    <body>
        <div class="nav">
            <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
            <% if (user != null) { %>
            <span id="links"><a href="account.jsp" style="text-decoration:none;">Account</a> | <a href="logout.jsp" style="text-decoration:none;">Logout</a></span> 
            <p>Hello ${user.userEmail}</p >
            <% } else { %>
            <span id="links"><a href="RegisterServlet" style="text-decoration:none;">Register</a> | <a href="LoginServlet" style="text-decoration:none;">Login</a></span> 
            <% }%>
        </div>
        <hr style="margin-top: 25px;"/>


        <div class="wholecontent">

            <div style="margin-left: 19%;">
                <a class="form-text text-info" href="searchdevice.jsp">Search Device</a>
                <a class="form-text text-info" href="devicepage.jsp">Show All Device</a>
            </div>

            <div class="things">   
                <img  src="css/device1.png" alt="background" width=300px height=300px>
                <img  src="css/device2.png" alt="background" width=300px height=300px>
                <img  src="css/device3.png" alt="background" width=300px height=300px>
            </div>
        </div>

        <jsp:include page="/ConnServlet" flush="true" />
    </body>

</html>

