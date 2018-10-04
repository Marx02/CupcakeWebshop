<%-- 
    Document   : mainPage
    Created on : 27-09-2018, 09:15:35
    Author     : caspe
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBConnector.Cupcake"%>
<%@page import="Orders.Order"%>
<%@page import="DBConnector.CupcakeTopping"%>
<%@page import="DBConnector.CupcakeBottom"%>
<%@page import="java.util.List"%>
<%@page import="DBConnector.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <head>
        <title>Cookie Clicker Bakeshop</title>
    <h1> <%
        User us = (User) request.getSession().getAttribute("user");
        out.print("Welcome  " + us.getuName() + "        Balance:   " + us.getBalance());
        %> 
    </h1>


</head>
<body>
<form method="get" action="http://localhost:8084/CupcakeWebshop/CartServlet">
    <button type="submit">Shopping Cart</button>
</form>
    <form action="http://localhost:8084/CupcakeWebshop/ProductControl" method="GET">
        <table class="table table-striped">
            <thead><tr><th>Bottom</th><th>Topping</th><th>Quantity</th><th>Select</th><th></th></tr></thead>
            <tbody>
                <tr>
                    <% ArrayList<CupcakeBottom> cb = (ArrayList) request.getSession().getAttribute("bottoms"); %>

                    <td><select name="bottom" id="bottomSelect">

                            <option>Choose bottom</option>


                            <% for (int i = 0; i < cb.size(); i++) {

                                    String np = cb.get(i).getName() + "  " + cb.get(i).getPrice() + "$";


                            %><option><% out.print(cb.get(i).getName());%></option>

                            <% }%>




                        </select></td>

                    <% ArrayList<CupcakeTopping> ct = (ArrayList) request.getSession().getAttribute("toppings"); %>
                    <td><select name="topping" id="toppingSelect">
                            <option>Choose topping</option>

                            <% for (int i = 0; i < ct.size(); i++) {

                                    String npt = ct.get(i).getName() + "  " + ct.get(i).getPrice() + "$";


                            %><option><% out.print(ct.get(i).getName());%></option>

                            <% }%>

                        </select></td>
                    <td><input type="number" name="qty" placeholder="quantity" id="qtyInput"></td>
                    <td><input type="submit" value="Add to cart"></td><td><span id="errorContainer"></span></td>


                </tr>
            </tbody>
        </table>
    </form>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    <table style="width:100%">

        <%
            try {
                HashMap<Cupcake, Integer> cakeList = (HashMap<Cupcake, Integer>) request.getSession().getAttribute("cakeList");
                Set<Map.Entry<Cupcake, Integer>> entries = cakeList.entrySet();
                for (Map.Entry<Cupcake, Integer> cl : entries) {
        %> <tr>
            <th><% out.println(cl.getValue() + " x  " + cl.getKey().getName()); %></th><%
            %><th><% out.println(cl.getKey().getPrice() * cl.getValue() + " KR"); %></th><%
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
</body>
</html>
