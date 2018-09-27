/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

/**
 *
 * @author KimPPedersen
 */
public class Order {
    
    int orderID;
    int userID;
    int price;
    int qty;
    String pname;
    String uname;
    String cname;

    public Order(int orderID, int userID, int price, int qty, String pname, String uname, String cname) {
        this.orderID = orderID;
        this.userID = userID;
        this.price = price;
        this.qty = qty;
        this.pname = pname;
        this.uname = uname;
        this.cname = cname;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String getPname() {
        return pname;
    }

    public String getUname() {
        return uname;
    }

    public String getCname() {
        return cname;
    }
    
}
