<%-- 
    Document   : editUserDetails
    Created on : 2021-5-15, 10:17:10
    Author     : Taoyuan Zhu
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Edit User Details</title>        
        <%
            User user = (User) session.getAttribute("user");
        %>        
    </head>
    <body>
        <div class="container">
            <h1>Edit details</h1>
            <form method="post" action="EditUserServlet">
                <table class="table table-bordered text-nowrap">
                    <tbody>
                        <tr>                          
                            <td><input class="form-control" type="text" name="email" value="${user.userEmail}" required></td>
                        </tr>
                        <tr>
                            <td><input class="form-control" type="text" name="name" value="${user.name}" required></td>
                        </tr>
                        <tr>
                            <td><input class="form-control" type="text" name="password" value="${user.password}" required></td>                            
                        </tr>
                        <tr>                           
                            <td><input class="form-control" type="text" name="phoneNumber" value="${user.phone}"></td>
                        </tr>
                    </tbody>                                                        
                </table>
                <div class="form-row">
                    <div class="form-group col">
                        <a href=" "><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
                    </div>
                    <div class="form-group col">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>                
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
