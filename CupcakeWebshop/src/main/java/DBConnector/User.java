/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

/**
 *
 * @author Esben
 */
class User {
    private String uName;
    private int balance;

    public User(String uName, int balance) {
        this.uName = uName;
        this.balance = balance;
    }

    public String getuName() {
        return uName;
    }

    public int getBalance() {
        return balance;
    }
    
    
}
