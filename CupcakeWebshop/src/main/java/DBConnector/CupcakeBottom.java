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
public class CupcakeBottom {

    String name;
    int price;

    /**
     * Puts together the object <code>CupcakeBottom</code> from a name and a price.
     *
     * @param name Name of the cupcake part
     * @param price Price of the cupcake part
     */
    public CupcakeBottom(String name, int price) {
        this.name = name;
        this.price = price;

    }

    /**
     * Returns the name of the <code>CupcakeBottom</code>.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the <code>CupcakeBottom</code>.
     *
     * @return int price
     */
    public int getPrice() {
        return price;
    }
    

}
