<%-- 
    Document   : main
    Created on : 2021-4-14, 0:19:42
    Author     : Taoyuan Zhu
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
        <title>Main Page</title>
        
    </head>
    <body>
        <div class="nav">
            <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
            <span id="links"><a href="welcome.jsp" style="text-decoration:none;">Back</a> | <a href="logout.jsp" style="text-decoration:none;">Logout</a></span>
        </div>
         <hr style="margin-top: 25px;"/>
         
         <div class="wholecontent">
             <div class="text">
                <h1 style="margin-top: 0px;">Personal Information</h1>
               <%
                   User user = (User)session.getAttribute("user");
               %>
               <table border="1" cellspacing="0" cellpadding="4"  class="tabtop13" align="left"  >
                   <tr bgcolor="#cccccc">
                       <th>Name</th>
                       <th>Email</th>
                       <th>Password</th>
                       <th>Phone</th>
                       <th>Date of Birth</th>
                       <th>Gender</th>
                   </tr>
                   <tr>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>${user.phone}</td>
                        <td>${user.dob}</td>
                        <td>${user.gender}</td>

                   </tr>
               </table>
             </div>
         </div>
                        
    </body>
</html>
