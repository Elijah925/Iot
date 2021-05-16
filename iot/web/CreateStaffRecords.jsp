<%-- 
    Document   : CreatStaffRecords
    Created on : 2021-5-15, 2:27:25
    Author     : Zizheng Xu
--%>

<%@page import="uts.isd.model.dao.DBManager"%>
<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/admin.css">
        <script type="text/javascript" src="js/index.js"></script>
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
        
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String positionErr = (String) session.getAttribute("positionErr");
            String nameErr = (String) session.getAttribute("nameErr");
            
            DBManager manager = (DBManager) session.getAttribute("manager");
        %>
        
            <p style="text-align:center;">
            <form style="margin: 0 auto; width: 250px;" action="AddStaffServlet"  method="post">
            
                <table class="table">
                <tr><td>Name:</td><td><input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter name")%>" name="name"></td></tr>
                <tr><td>Email:</td><td><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email"></td></tr>
                <tr><td>Position:</td><td><input type="text" placeholder="<%=(positionErr != null ? positionErr : "Enter position")%>" name="position"></td></tr>
                <tr><td>Address</td><td><input type="text" name="address" placeholder="Enter address"></td></tr>                
                <tr>
                    <td>Status</td>
                    <td>
                        <input type="checkbox" name="status">Activate
                    </td>
                </tr>
                <tr><td><input class="button" type="submit" value="Create"></td>
                    
                </table>
            </form>
            </p>
         
    </body>
</html>
