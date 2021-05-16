<%-- 
    Document   : EditStaff
    Created on : 2021-5-16, 16:34:55
    Author     : Zizheng Xu
--%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UpdateUserServlet" method="post">
                
                <table class="table table-bordered text-nowrap">
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="email"></td>
                        </tr>
                        <tr>
                            <td>Position</td>
                            <td><input type="text" name="position"></td>                            
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="address"></td>
                        </tr>
                        <tr>
                            <td>Activated</td>
                            <td><input  type="checkbox" name="status"></td>
                        </tr>
                        <tr><td><input class="button" type="submit" value="Update"></td>
                    </tbody>                                                        
                </table>  
            </form>
    </body>
</html>
