/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import DBConnector.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author KimPPedersen
 */
public class OrderMapper {

    public void storeOrder(Order nOrd) {
        try{
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String comm
                    ="INSERT INTO `orders` (price, qty,tprice,pname,uname) "
                    + "values('"+nOrd.getPrice()+"', '"+nOrd.getQty()+"', "+nOrd.getTprice()+", '"+nOrd.getPname()+"', "+nOrd.getUname()+");";
            stmt.execute(comm);
        } catch (Exception ex) {
            System.out.println("Couldn't save your order"); 
            ex.printStackTrace();
        }
    }

    public Order getOrderByID(Order o) {
        Order obyID = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM orders "
                    + "WHERE orderID = '" + o.getoID() + "';";
            ResultSet res = st.executeQuery(query);
            int oID = res.getInt("oID");
            int price = res.getInt("price");
            int qty = res.getInt("qty");
            double tprice = res.getDouble("tprice");
            String pname = res.getString("variant");
            String uname = res.getString("uname");
            obyID = new Order(oID, price, qty,tprice,pname,uname);
        } catch (Exception ex) {
            return null;
        }
        return obyID;
    }
}
