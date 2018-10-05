<%-- 
    Document   : index
    Created on : 27-09-2018, 09:26:56
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Please Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            h1 {text-align: center}
            h2 {text-align: center}
        </style>
    </head>
    <body>
        <h1>Cookie Clickers Bake Webshop</h1>
        <h2>Plz login to order sweet, SWEET cupcakes.</h2>
        <form method="POST" action="/CupcakeWebshop-1.0-SNAPSHOT/Login">
            <p>
                Username:<br/>
                <input type ="text" name ="username"><br/>
                Password:<br/>
                <input type ="password" name ="password"><br/>
                <input type="submit" value="Login">
            </p>
        </form>
    </body>
</html>
<%-- Her skal der så skrives en knap der dirigerer videre til newUser.jsp, hvis man vil oprette en ny bruger  --%>
