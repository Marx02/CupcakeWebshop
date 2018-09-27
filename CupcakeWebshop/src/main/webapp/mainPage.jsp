<%-- 
    Document   : mainPage
    Created on : 27-09-2018, 09:15:35
    Author     : caspe
--%>

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
        out.print(us.getuName());
        %> 
    </h1>


</head>
<body>
    <form action="http://localhost:8084/CupcakeWebshop/ShopServlet" method="POST">
        <input type="text" name="amount" placeholder="Enter amount"/>
        <input type="submit" value="Add to wallet" formaction="/updateBalance"> <!update balance skal laves>
    </form>
    <form action="http://localhost:8084/CupcakeWebshop/ShopServlet" method="POST">
        <form id="addProduct" action="http://localhost:8084/CupcakeWebshop/ShopServlet" method="POST">
            <input type="hidden" name="origin" value="addProduct">
            <table class="table table-striped">
                <thead><tr><th>Bottom</th><th>Topping</th><th>Quantity</th><th>Select</th><th></th></tr></thead>
                <tbody>
                    <tr>
                        <% List<CupcakeBottom> cb = (List) request.getSession().getAttribute("bottoms"); %>

                        <td><select name="bottom" id="bottomSelect">

                                <option value="0">Choose bottom</option>

                                <% for (int i = 0; i < cb.size(); i++) {

                                        String np = cb.get(i).getName() + "  " + cb.get(i).getPrice() + "$";


                                %><option value="<% cb.get(i); %>"><% out.print(np);%></option>

                                <% }%>




                            </select></td>
                            
                            <% List<CupcakeTopping> ct = (List) request.getSession().getAttribute("toppings"); %>
                        <td><select name="topping" id="toppingSelect">
                                <option value="0">Choose topping</option>

                                 <% for (int i = 0; i < ct.size(); i++) {

                                        String npt = ct.get(i).getName() + "  " + cb.get(i).getPrice() + "$";


                                %><option value="<% ct.get(i); %>"><% out.print(npt);%></option>

                                <% }%>
   
                            </select></td>
                        <td><input type="text" name="qty" placeholder="quantity" id="qtyInput"></td>
                        <td><input type="submit" name="submit" value="Add to cart"></td><td><span id="errorContainer"></span></td>
                    </tr>
                </tbody>
            </table>
        </form>
</body>
</html>
