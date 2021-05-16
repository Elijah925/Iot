<%-- 
    Document   : Landingjsp
    Created on : 2021-5-15, 0:15:02
    Author     : Zizheng Xu
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <% String test = (String) session.getAttribute("test");%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/admin.css"> 
        <title>Administration</title>
    </head>
    <body>
        <h1>Welcome to the Administration Page.</h1>
        
        <ul>
            <li><a href="Landing.jsp">Home</a></li>
            <li><a href="CreateStaffRecords.jsp">Create Staff Records</a></li>
            <li><a href="ViewStaffMembers.jsp">View Staff Records</a></li>
            <li><a href="AdminLogout.jsp">Logout</a></li>
        </ul>
        <p style="text-align:center;">
            This is the administration page for the IotBay.      
        </p>

    </body>
</html>
