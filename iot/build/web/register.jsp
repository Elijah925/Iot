<%-- 
    Document   : register
    Created on : 2021-4-13, 22:18:44
    Author     : Taoyuan Zhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/register.css">
        <title>Register Page</title>
    </head>
    <body>
        <div class="nav">
            <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
            <span id="links"><a href="login.jsp"  style="text-decoration:none;">Login</a> | <a href="index.jsp"  style="text-decoration:none;" >Home</a></span>
          
        </div >
       
        <hr style="margin-top: 25px;"/>
        <div class="wholecontent">   
            
       
            <div class="content">
                <h2>Register for IoTBay Account</h2>
                <form id="form" action="RegisterServlet"  method="post">
                <table id="table">

                    <tr><td><input type="text" placeholder="Enter your name" name="name" required="true"></td></tr>
                    <tr><td><input type="text" placeholder="Enter your email" name="email" required="true"></td></tr>
                    <tr><td><input type="password" placeholder="Enter your password" name="password" required="true"></td></tr>
                    <tr><td><input type = "password" placeholder="confirm password"/></td></tr>
                    <tr><td><input type="text" placeholder="Enter your phone" name="phone" required="true"></td></tr>                                                              
                            </select>
                        </td></tr>

                </table>
                <div>
                    <a href="index.jsp">Cancle</a>  <input class="button" type="submit" value="Sign Up">
                </div>
            </form>
            </div>
        </div>
    </body>
</html>
