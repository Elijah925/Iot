<%-- 
    Document   : deleteUser
    Created on : 2021-5-15, 10:29:06
    Author     : Taoyuan Zhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Account</title>
    </head>
    <body>
        <div class="container text-center">
            <h1>Delete Account</h1>
            <p>Are you sure you want to delete your account?</p >
            <p>If you choose to delete you account, your data will be permanently deleted from the system.</p >
            <form method="post" action="DeleteUserServlet">
                <div class="form-row justify-content-center">
                    <div class="form-group col-3">
                        <a href=" "><button type="button" class="btn btn-secondary btn-block">Back</button></a>
                    </div>
                    <div class="form-group col-3">
                        <button class="btn btn-danger btn-block" type="submit">Delete Account</button>                
                    </div>
                </div>
            </form>
        </div>        
    </body>
</html>