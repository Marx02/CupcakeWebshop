/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import Orders.Order;

/**
 *
 * @author Esben
 */
public class User {
    private final String uName;
    private int balance;
    private boolean loggedIn;
    private Order userOrder;

    /**
     * Constructs a <code>User</code> object from a <code>String</code> username, <code>int</code> balance and <code>boolean</code> loggedIn. The boolean is usde to check wether the user is actually logged in.
     *
     * @param uName Username   
     * @param balance Account balance
     * @param loggedIn  Is the user logged in?
     */
    public User(String uName, int balance, boolean loggedIn) {
        this.uName = uName;
        this.balance = balance;
        this.loggedIn = loggedIn;
    }

    /**
     * Returns the String name of the <code>User</code> object.
     *
     * @return username as String
     */
    public String getuName() {
        return uName;
    }

    /**
     * Returns the int balance of the <code>User</code> object.
     *
     * @return int balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the int balance of the <code>User</code> object.
     *
     * @param balance Account balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Returns the boolean loggedIn of the <code>User</code> object.
     *
     * @return logged in status
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets the boolean loggedIn of the <code>User</code> object.
     *
     * @param loggedIn status
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * Returns the <code>Order</code> userOrder of the <code>User</code> object.
     *
     * @return list of orders
     */
    public Order getUserOrder() {
        return userOrder;
    }

    /**
     * Adds a <code>Order</code> object to the list of orders int the <code>User</code> object.
     *
     * @param userOrder order to be saved
     */
    public void setUserOrder(Order userOrder) {
        this.userOrder = userOrder;
    }
    
    
    
}
