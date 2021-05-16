<%-- 
    Document   : EditStaffDetails
    Created on : 2021-5-15, 14:01:06
    Author     : Zizheng Xu
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/admin.css">
        <title>Edit User Details</title>        
        <%
            Staff stafftoedit = (Staff) session.getAttribute("StaffToEdit");
        %>        
    </head>
    <body>
        <div class="container">
            <h1>Edit details</h1>
            <form action="UpdateStaffServlet" method="post">
                <input type="hidden" name="usertofind" value="<%= stafftoedit.getName()%>">
                <table align="center">
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="name" placeholder="<%= stafftoedit.getName()%>"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="email" placeholder="<%= stafftoedit.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td>Position</td>
                            <td><input type="text" name="position" placeholder="<%= stafftoedit.getPosition()%>"></td>                            
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="address" placeholder="<%= stafftoedit.getAddress()%>"></td>
                        </tr>
                        <tr>
                            <td>Activated</td>
                            <td><input  type="checkbox" name="status"></td>
                        </tr>
                        <tr><td><input class="button" type="submit" value="Update"></td>
                    </tbody>                                                        
                </table>  
            </form>
        </div>
    </body>
</html>
