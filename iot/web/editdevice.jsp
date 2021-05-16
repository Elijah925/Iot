<%-- 
    Document   : editdevice
    Created on : 2021-5-15, 23:56:54
    Author     : 47288
--%>
<%@page import="uts.isd.model.Device"%>
<%@page import="uts.isd.model.dao.DeviceManager"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            Device device = (Device) session.getAttribute("device");
            String typeErr = (String) session.getAttribute("typeErr");
            String updateErr = (String) session.getAttribute("updateErr");
            String existErr = (String) session.getAttribute("existErr");
            String typeErrD = (String) session.getAttribute("typeErrD");
            String resultInfor = (String) session.getAttribute("resultInfor");
        %>
        <% if (user != null) { %>
        <div class="nav">
            <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
            <span id="links"><a href="index.jsp" style="text-decoration:none;">Back</a> | <a href="account.jsp" style="text-decoration:none;">account</a></span>
        </div>
        <% } else { %>
        <div class="nav">
            <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
            <span id="links"><a href="index.jsp" style="text-decoration:none;">Back</a> | <a href="register.jsp" style="text-decoration:none;">Register</a></span>
        </div>
        <% }%>
        <hr style="margin-top: 25px;"/>

        <div>
            <h1>Edit Device Detail</h1> <small><%=(resultInfor != null ? resultInfor : "")%></small>
        </div>


        <div class="content">
            <h2>Add Device</h2>
            <small><%=(existErr != null ? existErr : "")%></small>
            <form method="post" action="AddDeviceServlet">
                <table>
                    <tr><td>Device Name: </td><td><input type="text" placeholder="Enter name" name="deviceNameA" required="true"></td></tr>
                    <tr><td>Device Type </td><td><input type="text" placeholder="<%=(typeErr != null ? typeErr : "Enter type")%>" name="deviceTypeA" required="true"></td></tr>
                    <tr><td>Device Price </td><td><input type="text" placeholder="Enter price" name="devicePriceA" required="true"></td></tr>
                    <tr><td>Device Stock </td><td><input type="text" placeholder="Enter stock" name="deviceStockA" required="true"></td></tr>
                </table>
                <div>
                    <input class="button" type="submit" value="Add device">
                </div>
            </form>                
        </div>                         
        <br>

        <div class="content">
            <h2>Delete Device</h2>
            <small><%=(existErr != null ? existErr : "")%></small>
            <form method="post" action="DeleteDeviceServlet">
                <table>
                    <tr><td>Device Name: </td><td><input type="text" placeholder="Enter name" name="deviceNameD" required="true"></td></tr>
                    <tr><td>Device Type </td><td><input type="text" placeholder="<%=(typeErrD != null ? typeErrD : "Enter type")%>" name="deviceTypeD" required="true"></td></tr>
                </table>
                <div>
                    <input class="button" type="submit" value="Delete device">
                </div>
            </form>                
        </div>
        <br>     
        
        
        <div>
            <h2>Update Device</h2>
            <small><%=(updateErr != null ? updateErr : "")%></small>
            <form method="post" action="UpdateDeviceServlet">
                <table>
                    <tr><td>Device Name: </td><td><input type="text" value="${device.name}" placeholder="Enter name" name="deviceName" required="true"></td></tr>
                    <tr><td>Device Type </td><td><input type="text" value="${device.type}" placeholder="Enter type" name="deviceType" required="true"></td></tr>
                    <tr><td>Device Price </td><td><input type="text" value="${device.price}" name="devicePrice" required="true"></td></tr>
                    <tr><td>Device Stock </td><td><input type="text" value="${device.stock}" name="deviceStock" required="true"></td></tr>
                </table>
                <div>
                    <input class="button" type="submit" value="Update">
                </div>
            </form>
        </div>





    </body>
</html>
