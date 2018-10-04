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

    HashMap<Cupcake, Integer> shoppingCart = new HashMap();
    int orderID;
    int totalPrice;

    /**
     * Adds a cupcake to the HashMap shoppingCart
     * The key is the Cupcake object and the value is the quantity
     * 
     * 
     * @param cc the cupcake object being stored
     * @param qty quantity int
     */
    public void addCupcake(Cupcake cc, int qty) {
        shoppingCart.put(cc, qty);
    }
    
    /**
     * Calculates the price of all Cupcakes in the shoppingCart.
     * Also sets the int totalPrice on the Order object for use without calculation.
     * 
     * 
     * @return int total price of the shoppingCart
     */
    public int setTotalPrice() {
        totalPrice = 0;
        Set<Map.Entry<Cupcake, Integer>> entries = shoppingCart.entrySet();
        for(Map.Entry<Cupcake, Integer> sc : entries){
            totalPrice += sc.getValue() * sc.getKey().getPrice();
        }
        return totalPrice;
    }

    public HashMap<Cupcake, Integer> getCupcakes() {
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
