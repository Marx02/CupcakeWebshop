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
    public int price = 0;

    public Cupcake(CupcakeTopping topping, CupcakeBottom bottom) {
        this.topping = topping;
        this.bottom = bottom;

    }

    public String getName() {
        return bottom.getName() + " with " + topping.getName();
    }

    public int getPrice() {
        return bottom.getPrice() + topping.getPrice();
    }

}
