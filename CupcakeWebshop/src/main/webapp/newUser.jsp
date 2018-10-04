<%-- 
    Document   : newUser
    Created on : 27-09-2018, 11:25:55
    Author     : Esben
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
            p {text-align: center}
        </style>
    </head>
    <body>
        <h1>Cookie Clickers Bake Webshop</h1>
        <h2>Plz login to order sweet, SWEET cupcakes.</h2>
        <form method="POST" action="http://localhost:8084/CupcakeWebshop/Login">
            <p>
                Username:<br/>
                <input type ="text" name ="username"><br/>
                Password:<br/>
                <input type ="password" name ="password"><br/>
                Confirm Password:<br/>
                <input type="password" name ="cPassword"
                <input type="submit" value="Register">
            </p>
        </form>
    </body>
</html>