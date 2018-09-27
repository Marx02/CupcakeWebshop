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
public class User {
    private String uName;
    private int balance;
    private boolean loggedIn;

    public User(String uName, int balance, boolean loggedIn) {
        this.uName = uName;
        this.balance = balance;
        this.loggedIn = loggedIn;
    }

    public String getuName() {
        return uName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    
}
