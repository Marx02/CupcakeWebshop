/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import DBConnector.Cupcake;
import DBConnector.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author KimPPedersen
 */
public class OrderMapper {

//    public void storeOrder(Order currentOrder) {
//        try {
//            Connection c = new DBConnector().getConnection();
//            Statement stmt = c.createStatement();
//            String comm
//                    = "INSERT INTO `order` (tprice) "
//                    + "values(" + currentOrder.getTotalPrice() + ");";
//            stmt.execute(comm);
//        } catch (Exception ex) {
//            System.out.println("Couldn't save your order");
//            ex.printStackTrace();
//        }
//        
//        ArrayList<Cupcake> cakeList = currentOrder.getCupcakes();
//
//        try {
//            Connection c = new DBConnector().getConnection();
//            Statement stmt = c.createStatement();
//            String comm
//                    = "INSERT INTO `order_has_products` (tprice) "
//                    + "values(" + currentOrder.getTotalPrice() + ");";
//            stmt.execute(comm);
//        } catch (Exception ex) {
//            System.out.println("Couldn't save your order");
//            ex.printStackTrace();
//        }
//    }
//
//    public Order getOrderDetailsByID(int orderID) {
//        Order obyID = null;
//        try {
//            Connection c = new DBConnector().getConnection();
//            Statement st = c.createStatement();
//            String query
//                    = "SELECT * "
//                    + "FROM order_has_products "
//                    + "WHERE orderID = " + o.getOrderID() + ";";
//            ResultSet res = st.executeQuery(query);
//            int oID = res.getInt("oID");
//            int price = res.getInt("price");
//            int qty = res.getInt("qty");
//            double tprice = res.getDouble("tprice");
//            String pname = res.getString("variant");
//            String uname = res.getString("uname");
//            obyID = new Order();
//            obyID.
//        } catch (Exception ex) {
//            return null;
//        }
//        return obyID;
//    }
}
