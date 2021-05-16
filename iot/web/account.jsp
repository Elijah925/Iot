<%-- 
    Document   : account
    Created on : 2021-5-15, 9:53:19
    Author     : Taoyuan Zhu
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
        <%
            User user = (User) session.getAttribute("user");
        %>    
    </head>
    <body>
        <div>
            <h1 class="text-center">IoTBay</h1>            
            <nav class="nav justify-content-center">
               <a  href=" ">Home</a>
                <a  href="account.jsp">Account</a>                    
                <a  href="logout.jsp">Logout</a>
            </nav>
            <div>
                <div>
                    <h2>Hi there ${user.name},</h2>
                    <p>Welcome to your account page, here you can view and edit your settings as well as check out your access logs through the links on the menu below.</p >
                </div>
                    <div class="container">
                        <h4>Account Details</h4>
                    </div>
                <div class="col">                    
                    <div>                        
                        <table class="table table-bordered text-nowrap">
                            <tbody>
                                <tr>
                                    <th class="">Email</th>
                                    <td>${user.userEmail}</td>
                                </tr>
                                <tr>
                                    <th class="">Name</th>
                                    <td>${user.name}</td>
                                </tr>
                                <tr>
                                    <th class="">Password</th>
                                    <td>${user.password}</td>
                                </tr>
                                <tr>
                                    <th class="">Phone Number</th>
                                    <% if (user.getPhone().isEmpty()) { %>
                                       <td>You have not entered a phone number</td>
                                    <% } else { %>
                                       <td>${user.phone}</td>
                                    <% } %>
                                </tr>
                            </tbody>                                                        
                        </table>
                     <div class="text-right">
                            <a href="deleteUser.jsp"><button type="button" class="btn btn-danger">Delete Account</button></a>
                        </div>
                    </div>
                </div>
                          
                    <div class="sidebar-expanded col-2 d-none d-md-block">                    
                        <nav class="list-group sticky-top sticky-offset">
                            <a href="EditUserServlet">Edit Details</a>
                            <a href="ViewAccessLogsServlet">Access Logs</a>     
                        </nav>                    
                    </div>
               
            </div>
        </div>       
    </body>
</html>
