/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import java.util.List;

/**
 *
 * @author Esben
 */
public class ShoppingCart {

    List<Cupcake> cupcakes;

    public ShoppingCart() {
    }

    public void addCupcake(Cupcake cc, int qty) {
        for (int i = 0; i < qty; i++) {
            this.cupcakes.add(cc);
        }
    }
    public int getTotalPrice(){
        int total = 0;
        for(int i = 0; i < cupcakes.size();i++){
            total += cupcakes.get(i).getPrice();
        }
        return total;
    }

    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }
    public void removeCupcake(Cupcake cc, int qty){
        for (int i = 0; i < qty; i++) {
            this.cupcakes.remove(cc);
        }
    }

}
