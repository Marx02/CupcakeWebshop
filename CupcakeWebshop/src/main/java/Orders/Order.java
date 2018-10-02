/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import DBConnector.Cupcake;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KimPPedersen
 */
public class Order {

    ArrayList<Cupcake> shoppingCart = new ArrayList();
    int orderID;
    int totalPrice;

    public void addCupcake(Cupcake cc, int qty) {
        for (int i = 0; i < qty; i++) {
            this.shoppingCart.add(cc);
        }
    }

    public int setTotalPrice() {
        totalPrice = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            totalPrice += shoppingCart.get(i).getPrice();
        }
        return totalPrice;
    }

    public ArrayList<Cupcake> getCupcakes() {
        return shoppingCart;
    }

    public void removeCupcake(Cupcake cc, int qty) {
        for (int i = 0; i < qty; i++) {
            this.shoppingCart.remove(cc);
        }
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}
