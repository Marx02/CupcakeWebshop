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
    
    int oID; //Order id
    int uID; //User id
    int price; //Price per cupcake
    int qty; //Quantity
    double tprice; //Total price
    String pname; //Productname
    String uname; //Username
    String cname; //Customername

    public Order(int oID, int uID, int price, int qty, double tprice, String pname, String uname, String cname) {
        this.oID = oID;
        this.uID = uID;
        this.price = price;
        this.qty = qty;
        this.tprice = tprice;
        this.pname = pname;
        this.uname = uname;
        this.cname = cname;
    }

    public int getoID() {
        return oID;
    }

    public int getuID() {
        return uID;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public double getTprice() {
        return tprice;
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
