<%-- 
    Document   : devicepage
    Created on : 2021-5-15, 18:59:57
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
        <title>Device Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            Device device =(Device) session.getAttribute("device");
            DeviceManager deviceManager = (DeviceManager) session.getAttribute("deviceManager");
            ArrayList<Device> deviceLists = deviceManager.fectDevice();
            String typeErr = (String) session.getAttribute("typeErr");
            String existErr = (String) session.getAttribute("existErr");
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
        <h1>Device Page</h1> 
        
        <% if (user != null && user.getIsStaff()) { %>       
           <div style="float: right">      
             <a class="form-text text-info" href="editdevice.jsp">Edit Device Page</a>
             <div>           
                <h2>Select the device you want to edit</h2>
                <small><%=(existErr != null ? existErr : "")%></small>
            <form method="post" action="FindEditDeviceServlet">
                    <table>
                        <tr><td>Device Name: </td><td><input type="text" placeholder="Enter name" name="deviceName" required="true"></td></tr>
                        <tr><td>Device Type </td><td><input type="text" placeholder="<%=(typeErr != null ? typeErr: "Enter type")%>" name="deviceType" required="true"></td></tr>
                  </table>
                  <div>
                     <input class="button" type="submit" value="Update">
                  </div>
                </form>
            </div>
        </div>     
           
            
            <% } else { %>
            <div></div>
            <% }%>
              
        
        <% if (device != null) { %>
            <div>                        
            <table class="table table-bordered text-nowrap">
                <tbody>
                    <tr>
                        <th class="">Name: </th>
                        <td>${device.name}</td>
                    </tr>
                    <tr>
                        <th class="">Type: </th>
                        <td>${device.type}</td>
                    </tr>
                    <tr>
                        <th class="">Price: </th>
                        <td>${device.price}</td>
                    </tr>
                    <tr>
                        <th class="">Stock: </th>
                        <td>${device.stock}</td>
                    </tr>
                </tbody>                                                        
            </table>
        </div>
            <% } else { %>
            <div></div>
            <% }%>
        
             
                    
         </div>
        <div class="container">
                        <h4>All Device</h4>
                    </div>

        <table>
            <thead>
                <tr>
                    <th width="300">Name</th>
                    <th width="150">Type</th>
                    <th width="70">Price</th>
                    <th width="70">Stock</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Device device1:deviceLists){
                %>
                    <tr>
                        <td width="300"><%=device1.getName()%></td>
                        <td width="150"><%=device1.getType()%></td>
                        <td width="70"><%=device1.getPrice()%></td>
                        <td width="70"><%=device1.getStock()%></td>
                       
                    </tr>
                    <%}%>
                    
            </tbody>
        </table>

    </body>
</html>
