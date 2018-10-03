<%-- 
    Document   : shoppingCart
    Created on : 02-Oct-2018, 18:01:56
    Author     : uber
--%>

<%@page import="DBConnector.User"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
                HashMap<Integer, Cupcake> cakeList = (HashMap<Integer, Cupcake>) request.getSession().getAttribute("cakeList");
                Set<Map.Entry<Integer, Cupcake>> entries = cakeList.entrySet();
                for (Map.Entry<Integer, Cupcake> cl : entries) {
        %> <tr>
            <th><% out.println(cl.getValue().getName() + " x  " + cl.getKey()); %></th><%
            %><th><% out.println(cl.getKey() * cl.getValue().getPrice() + " KR"); %></th><%
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
                %></tr><%
                    }

            %>
        <th>
            <% 
                User currentUser = (User) request.getSession().getAttribute("user");
                
                out.print(currentUser.getUserOrder().getTotalPrice() + " KR");
            %>
        </th>


    </table>

</head>
<body>
</body>
</html>
