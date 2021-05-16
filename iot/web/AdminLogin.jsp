<%-- 
    Document   : logout
    Created on : 13/05/2020, 2:36:37 PM
    Author     : Zizheng Xu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ page import="uts.isd.model.Staff" %>
    <%@ page import="uts.isd.model.dao.*"%>
    <%@ page import="uts.isd.model.*" import="java.sql.*"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/admin.css"> 
        <title>Login</title>
    </head>
    <body>
        <h1 style="text-align:center; background-color: black;color: white">IOTBAY</h1>
        <h2 style="text-align:center;">Administration Login</h2>
        <p style="text-align:center;">
        <h4 >Enter your details to login:</h4>

        <form style="margin: 0 auto; width: 250px;">

            <table>                
                <tr><td>Admin Email:</td><td><input type="text" name="email"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password"></td></tr>                
                <tr>
                    <td></td>
                    <td>
                        <button class="button" type="button" onclick="location.href = 'Landing.jsp'" > Login </button>
                        <button class="button" type="button" onclick="location.href = 'index.jsp'" > Home Page </button>

                    </td>
                </tr>
            </table>
        </form>
        
     <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
