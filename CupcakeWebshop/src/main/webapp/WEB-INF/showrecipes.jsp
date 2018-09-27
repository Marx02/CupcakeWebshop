<%-- 
    Document   : showrecipes
    Created on : 26-09-2018, 08:51:22
    Author     : caspe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All recipes:</h1>
        <%= out.print(request.getAttribute("recipesKey"))%>
    </body>
</html>
