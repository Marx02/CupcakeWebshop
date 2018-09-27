/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import DBConnector.DBConnector;
import DBConnector.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author KimPPedersen
 */
public class OrderMapper {

    public Order getOrderByID(int oID, int uID, int price, int qty, double tprice, String pname, String uname, String cname) {
        Order obyID = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM orders "
                    + "WHERE orderID = '"+ oID +"';" ;
            ResultSet res = st.executeQuery(query);
            oID = res.getInt("oID");
            uID = res.getInt("uID");
            price = res.getInt("price");
            qty = res.getInt("qty");
            tprice = res.getDouble("tprice");
            pname = res.getString("variant");
            uname = res.getString("uname");
            cname = res.getString("cname");
        } catch (Exception ex) {
            return null;
        }
        return obyID;
    }
}    
