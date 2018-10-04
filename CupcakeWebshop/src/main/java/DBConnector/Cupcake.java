/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

/**
 *
 * @author caspe
 */
public class Cupcake {

    public CupcakeTopping topping;
    public CupcakeBottom bottom;

    /**
     *Takes a <code>CupcakeTopping</code> and a <code>CupcakeBottom</code>
     * and combine them into a object.
     * 
     * @param topping
     * @param bottom
     */
    public Cupcake(CupcakeTopping topping, CupcakeBottom bottom) {
        this.topping = topping;
        this.bottom = bottom;

    }

    /**
     *Generates the name of the cupcake, combined from top and
     * bottom of the requested cupcake.
     * 
     * @return String Name
     */
    public String getName() {
        return bottom.getName() + " " + topping.getName();
    }

    /**
     * Generates the total price of the cupcake, combined from
     * top and bottom of the requested cupcake.
     *
     * @return int price of the cupcake
     */
    public int getPrice() {
        return bottom.getPrice() + topping.getPrice();
    }

}
