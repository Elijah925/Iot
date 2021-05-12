<%-- 
    Document   : login
    Created on : 2021-4-13, 22:18:32
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css">
        <title>Login Page</title>
    </head>
    <body>
       
         <div class="nav">
            <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
             <span id="links"><a href="welcome.jsp" style="text-decoration:none;">Back</a> | <a href="register.jsp" style="text-decoration:none;">Register</a></span>
         </div>
         <hr style="margin-top: 25px;"/>
        <div class="wholecontent">
            <div class="content">
                <h2>Login for IoTBay Account</h2>
                  <form action="welcome.jsp"  method="post">
                  <table>

                      <tr><td><input type="text" placeholder="Enter your name" name="Name" required="true"></td></tr>
                      <tr><td><input type="text" placeholder="Enter your email" name="Email" required="true"></td></tr>
                      <tr><td><input type="password" placeholder="Enter your password" name="Password" required="true"></td></tr>


                  </table>
                  <div>
                     <input class="button" type="submit" value="Login">
                  </div>
                  </form>
            </div>
            
        </div>
        
    </body>
</html>
