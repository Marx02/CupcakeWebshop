/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import DBConnector.Cupcake;
import DBConnector.DataMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author KimPPedersen
 */
public class Order {

    HashMap<Integer, Cupcake> shoppingCart = new HashMap();
    int orderID;
    int totalPrice;

    public void addCupcake(Cupcake cc, int qty) {
        shoppingCart.put(qty, cc);
    }

    public int setTotalPrice() {
        totalPrice = 0;
        Set<Map.Entry<Integer, Cupcake>> entries = shoppingCart.entrySet();
        for(Map.Entry<Integer, Cupcake> sc : entries){
            totalPrice += sc.getValue().getPrice() * sc.getKey();
        }
        return totalPrice;
    }

    public HashMap<Integer, Cupcake> getCupcakes() {
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

}
