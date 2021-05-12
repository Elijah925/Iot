<%-- 
    Document   : register
    Created on : 2021-4-13, 22:18:44
    Author     : lenovo
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
                <form id="form" action="welcome.jsp"  method="post">
                <table id="table">

                    <tr><td><input type="text" placeholder="Enter your name" name="Name" required="true"></td></tr>
                    <tr><td><input type="text" placeholder="Enter your email" name="Email" required="true"></td></tr>
                    <tr><td><input type="password" placeholder="Enter your password" name="Password" required="true"></td></tr>
                    <tr><td><input type = "password" placeholder="Confirm Password"/></td></tr>
                    <tr><td><input type="text" placeholder="Enter your phone" name="Phone" required="true"></td></tr>
                    <tr><td><input type="date" name="dob"/> </td></tr>
                    <tr><td><select name="Gender">
                                <option value="">Gender</option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="other">Other</option>                                                                
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
