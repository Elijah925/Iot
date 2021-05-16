<%-- 
    Document   : SuccessfulNotification
    Created on : 2021-5-16, 17:42:56
    Author     : Zizheng Xu
--%>
<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String edited = (String)session.getAttribute("edited");
            session.invalidate();
        %>
        <title>JSP Page</title>
    </head>
    <body>

        <%if(edited != null){%>
            <h1><%= edited%></h1>
        <%}%>

        <a href = "index.jsp">click here to continue</a>
        
        <jsp:include page="/ConnServlet" flush="true" />  
    </body>
</html>
