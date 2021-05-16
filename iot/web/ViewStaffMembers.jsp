<%-- 
    Document   : ViewStaffMembers
    Created on : 13/05/2020
    Author     : Zizheng Xu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.dao.DBManager"%>
<%@page import="uts.isd.model.Staff"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/admin.css">
        <title>Staff Page</title>
    </head>
    <body>
   
        <%
            DBManager manager =(DBManager)session.getAttribute("manager");  
            ArrayList<Staff> Stafflist = manager.fetchStaffs();
            Staff searchResult = (Staff)session.getAttribute("stafftofind");
         
        %>
        
            
        <h1 style="text-align:center; background-color: black;color: white">IOTBAY</h1>
            
        <ul>
            <li><a href="Landing.jsp">Home</a></li>
            <li><a href="CreateStaffRecords.jsp">Create Staff Records</a></li>
            <li><a href="ViewStaffMembers.jsp">View Staff Records</a></li>
            <li><a href="AdminLogout.jsp">Logout</a></li>
        </ul>
        <div class="search">
            <form action = "findStaffServlet" Method = "post">
            <input class="searchinput" type="text" name="name" placeholder="user name">
            <input class="searchinput" type="text" name="position" placeholder="position">
            <button type="submit" class="searchbutton">Search</button>
            </form>
            <div class="container">
                        <h4>All Staffs</h4>
            </div>
           
        <table class="viewstaff">
            <tr>
                <th>NAME</th>
                <th>EMAIL</th>
                <th>STAFF POSITION</th>
                <th>ADDRESS</th>
                <th>STATUS</th>
            </tr>
            <tbody>
                <%
                    if(searchResult == null){
                    for(Staff staff: Stafflist){
                %>
                    <tr>
                        <td width="70"><%=staff.getName()%></td>
                        <td width="150"><%=staff.getEmail()%></td>
                        <td width="70"><%=staff.getPosition()%></td>
                        <td width="300"><%=staff.getAddress()%></td>
                        <td width="70"><%=staff.getStatus()%></td>
                        <td width="70">
                            <form action = "EditStaffServlet" method="post"><input type ="hidden" name = "name" value="<%=staff.getName()%>" /><button type ="submit">Edit</button></form>
                            <form action = "DeleteStaffServlet" method="post"><input type ="hidden" name = "name" value="<%=staff.getName()%>" /><button type ="submit">Delete</button></form>
                        </td>
                    </tr>
                    <%}}else{%>
                    <tr>
                        <td width="70"><%=searchResult.getName()%></td>
                        <td width="150"><%=searchResult.getEmail()%></td>
                        <td width="70"><%=searchResult.getPosition()%></td>
                        <td width="300"><%=searchResult.getAddress()%></td>
                        <td width="70"><%=searchResult.getStatus()%></td>
                    </tr>
                <%}%>
                    
            </tbody>
        </table>
           
    </body>
</html>

