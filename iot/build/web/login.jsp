<%-- 
    Document   : login
    Created on : 2021-4-13, 22:18:32
    Author     : Taoyuan Zhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css">
        <title>Login Page</title>
        <%            
            String existErr = (String) session.getAttribute("existErr");
            String loginErr = (String) session.getAttribute("loginErr");
            String passErr = (String) session.getAttribute("passErr");
            String emailErr = (String) session.getAttribute("emailErr");
        %>
    </head>
    <body>
       
         <div class="nav">
            <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
             <span id="links"><a href=" " style="text-decoration:none;">Back</a> | <a href="register.jsp" style="text-decoration:none;">Register</a></span>
         </div>
         <hr style="margin-top: 25px;"/>
         
        <div class="wholecontent">
            <div class="content">
                <h2>Login for IoTBay Account</h2>
                <small><%=(existErr != null ? existErr : "")%></small>
                <small><%=(loginErr != null ? loginErr : "")%></small>
                
                
                <form method="post" action="LoginServlet">
                    <table>
                      <tr><td><input type="text" placeholder="Enter your email" name="email" required="true"></td></tr>
                      <tr><td><input type="password" placeholder="Enter your password" name="password" required="true"></td></tr>
                  </table>
                  <div>
                     <input class="button" type="submit" value="Login">
                  </div>
                    <div>
                        <a class="form-text text-info" href="register.jsp">Haven't made an account yet? Register here!</ a>
                    </div>
                </form>
                  
                
                
            </div>
            
        </div>
        
    </body>
</html>