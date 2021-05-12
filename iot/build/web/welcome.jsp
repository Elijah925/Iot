<%-- 
    Document   : welcome
    Created on : 2021-4-13, 22:19:56
    Author     : lenovo
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/welcome.css">
        <title>Welcome page</title>
    </head>
    <body>
        <div class="nav">
             <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
             <span id="links"><a href="main.jsp" style="text-decoration:none;">Main</a> | <a href="logout.jsp" style="text-decoration:none;">Logout</a></span>
          
        </div >
       
        <hr style="margin-top: 25px;"/>
        <div class="wholecontent">   
     
          
             <% String name = request.getParameter("Name"); %>
             <% String email = request.getParameter("Email"); %>
             <% String password = request.getParameter("Password"); %>
             <% String phone = request.getParameter("Phone"); %>
             <% String dob = request.getParameter("dob"); %>
             <% String gender = request.getParameter("Gender"); %>
             
             <% 
                User user = new User(name,email,password,phone,dob,gender);
                session.setAttribute("user", user);
             %>
             <div class="text">
                <h1 style="margin-top: 0px;"> Welcome, <%= name %> !</h1>
                <h1> Your email is <%= email %> !</h1>
                <h1> Your password is <%= password %> !</h1>
             </div>
        </div>
    </body>
</html>
