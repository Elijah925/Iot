<%-- 
    Document   : accesslog
    Created on : 2021-5-15, 10:39:03
    Author     : Taoyuan Zhu
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.AccessLog"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Access Logs</title>
        <%
            User user = (User) session.getAttribute("user");
            String timeFilterErr = (String) session.getAttribute("timeFilterErr");            
            String dateParseError = (String) session.getAttribute("dateParseError"); 
            String filterErr = (String) session.getAttribute("filterErr");
            String filterText = (String) session.getAttribute("filterText");
            ArrayList<AccessLog> accessLogs = new ArrayList<AccessLog>();
            accessLogs = (ArrayList) session.getAttribute("accessLogs");
            Date date = new Date();
            Timestamp time = new Timestamp(date.getTime());
        %>
    </head>
    <body>
        <div class="container">
            <h1>Access Logs</h1>
            <form method="post" action="ViewAccessLogsServlet">
                <div class="form-row">
                    <div class="form-group col">
                        <label for="startDate">Start date:</label>
                            <input type="date" name="startDate">
                        <label for="startDate">End date:</label>
                            <input type="date" name="endDate">
                            <button class="btn btn-primary btn-sm btn-inline" type="submit">Search</button>
                    </div>                    
                </div>                                                               
            </form>

        <table>
            <thead>
                <tr>
                    <th>Log time</th>
                    <th>Log event</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${accessLogs}" var="accessLog">
                    <tr>
                        <td>${accessLog.getPrettyLogEventTime()}</td>
                        <td>${accessLog.getLogEvent()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="form-row">
            <div class="form-group col">
                <a href=" "><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
            </div>                    
        </div>
    </div>
    </body>
</html>
