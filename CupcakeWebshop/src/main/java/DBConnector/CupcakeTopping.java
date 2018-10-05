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
public class CupcakeTopping {

    String name;
    int price;

    /**
     * Puts together the object <code>CupcakeTopping</code> from a name and a price.
     *
     * @param name
     * @param price
     */
    public CupcakeTopping(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the <code>CupcakeBottom</code>.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the <code>CupcakeBottom</code>.
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

}
