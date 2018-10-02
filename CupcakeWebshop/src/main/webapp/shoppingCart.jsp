<%-- 
    Document   : shoppingCart
    Created on : 02-Oct-2018, 18:01:56
    Author     : uber
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DBConnector.Cupcake"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    <table style="width:30%">

        <%
            try {
                ArrayList<Cupcake> cakeList = (ArrayList<Cupcake>) request.getSession().getAttribute("cakeList");
                for (Cupcake c : cakeList) {
        %> <tr>
            <th><% out.println(c.getName());%></th><%
            %><th><% out.println(c.getPrice() + " KR"); %></th><%
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
                %></tr><%
                    }

            %>
        <th>
            <% int totalPrice = 0;
                ArrayList<Cupcake> cakeList = (ArrayList<Cupcake>) request.getSession().getAttribute("cakeList");
                for (Cupcake c : cakeList) {
                    totalPrice += c.getPrice();
                }
                out.print(totalPrice + " KR");
            %>
        </th>


    </table>

</head>
<body>
</body>
</html>
