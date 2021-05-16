<%-- 
    Document   : logout
    Created on : 13/05/2020, 2:36:37 PM
    Author     : Zizheng Xu
--%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ page import="uts.isd.model.Staff" %>
    <%@ page import="uts.isd.model.dao.*"%>
    <%@ page import="uts.isd.model.*" import="java.sql.*"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logging Out</title>
    </head>
    <body>
        <%
        session.invalidate();
        response.sendRedirect("AdminLogin.jsp");
        %>
    </body>
</html>
