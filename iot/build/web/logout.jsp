<%-- 
    Document   : logout
    Created on : 2021-4-14, 0:11:08
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/logout.css">
        <title>Logout Page</title>
    </head>
    <body>
        
          <div class="nav">
             <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
            
          </div>
       
        <hr style="margin-top: 25px;"/>
          <div class="wholecontent">   
                 <div class="text">
                    <h1 style="margin-top: 0px;">You have been logged out. Click <a href="index.jsp">here</a> to return to the main page.</h1>
                    <% 
                        session.invalidate();
                    %>
                 </div>
          </div>
    </body>
</html>
