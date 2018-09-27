/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import DBConnector.Cupcake;
import java.util.List;

/**
 *
 * @author KimPPedersen
 */
public class Order {

    private int oID; //Order id
    private int price; //Price per cupcake
    private int qty; //Quantity
    private double tprice; //Total price
    private String pname; //Productname
    private String uname; //Username
    private List<Cupcake> shoppingCart;

    public void addCupcake(Cupcake cc, int qty) {
        for (int i = 0; i < qty; i++) {
            this.shoppingCart.add(cc);
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            total += shoppingCart.get(i).getPrice();
        }
        return total;
    }

    public List<Cupcake> getCupcakes() {
        return shoppingCart;
    }

    public void removeCupcake(Cupcake cc, int qty) {
        for (int i = 0; i < qty; i++) {
            this.shoppingCart.remove(cc);
        }
    }

    public Order(int oID, int price, int qty, double tprice, String pname, String uname) {
        this.oID = oID;
        this.price = price;
        this.qty = qty;
        this.tprice = tprice;
        this.pname = pname;
        this.uname = uname;
    }

    public int getoID() {
        return oID;
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
}
