<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css">
        <title>Search Device</title>
        <%            
            String typeErr = (String) session.getAttribute("typeErr");
            String existErr = (String) session.getAttribute("existErr");
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
                <h2>Search device</h2>
                <small><%=(existErr != null ? existErr : "")%></small>
              <form method="post" action="FindDeviceServlet">
                    <table>
                        <tr><td>Device Name: </td><td><input type="text" placeholder="Enter name" name="deviceName" required="true"></td></tr>
                        <tr><td>Device Type </td><td><input type="text" placeholder="<%=(typeErr != null ? typeErr: "Enter type")%>" name="deviceType" required="true"></td></tr>
                  </table>
                  <div>
                     <input class="button" type="submit" value="Search">
                  </div>
                </form>
                
            </div>
            
        </div>
        
    </body>
</html>