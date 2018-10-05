/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esben
 */
public class DataMapper {
//  ** ONLY FOR TESTING **
//    public static void main(String[] args) {
//        DataMapper m = new DataMapper();
//        System.out.println(m.getBottom("Chocolate").getPrice());
//        System.out.println(m.getTopping("Chocolate").getPrice());
//        System.out.println(m.getAllBottoms().get(1).getName());
//    }

    /**
     * Gets the username and password <code>getUserInfo</code> Check if its
     * valid, by comparing the info from the database If string password is not
     * correct, it returns a user with "Wrong pass" as name If the username is
     * also incorrect, it returns a user named "Error"
     *
     *
     * @param uName is the username
     * @param password is the password for login, connected to the username
     * @return aUser
     */
    public User getUserInfo(String uName, String password) {
        User aUser = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT pw FROM users WHERE username = '" + uName + "';";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                String pass = res.getString("pw");
                if (pass.equals(password)) {
                    aUser = new User(uName, 100, true);
                } else {
                    aUser = new User("Wrong pass", 0, false);
                }
            }
        } catch (Exception ex) {
            aUser = new User("Error", 0, false);
            return aUser;

        }
        return aUser;
    }

    /**
     * Gets the values "variant" and "price" of a cupcakebottom, by its string
     * name, from the database. Then it will return the chosen cupcakebottom
     * with its two values.
     *
     * @param name which is the name of the bottom type
     * @return CuocakeBottom
     */
    public CupcakeBottom getBottom(String name) {
        CupcakeBottom a = null;
        int price = 0;
        String variant = "";
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM bottoms "
                    + "WHERE variant = '" + name + "';";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                variant = res.getString("variant");
                price = res.getInt("price");
                a = new CupcakeBottom(variant, price);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return a;
    }

    /**
     * Gets the values "variant" and "price" of a cupcaketopping, by its string
     * name, from the database. Then it will return the chosen cupcaketopping
     * with its two values.
     *
     * @param name which is the name of the topping type
     * @return topping that has been chosen
     */
    public CupcakeTopping getTopping(String name) {
        int price = 0;
        String variant = "";
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM toppings "
                    + "WHERE `variant` = '" + name + "';";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                variant = res.getString("variant");
                price = res.getInt("price");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        CupcakeTopping b = new CupcakeTopping(variant, price);
        return b;
    }
    
    /**
     * Creates an arrayList of all cupcaketoppings with its 
     * two values (String variant, int price) from the database
     * and then returns it as CTList
     * 
     * @return a full list of cupcaketoppings
     */

    public ArrayList<CupcakeTopping> getAllToppings() {
        int price;
        String variant;
        ArrayList<CupcakeTopping> CTList = new ArrayList();
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT *"
                    + "FROM `toppings`;";

            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                price = res.getInt("price");
                variant = res.getString("variant");
                CupcakeTopping b = new CupcakeTopping(variant, price);
                CTList.add(b);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return CTList;
    }

    /**
     * Creates an arrayList of all cupcakebottoms with its 
     * two values (String variant, int price) from the database
     * and then returns it as CBList
     * 
     * @return a full list of cupcakebottoms
     */
    
    public ArrayList<CupcakeBottom> getAllBottoms() {
        int price;
        String variant;
        ArrayList<CupcakeBottom> CBList = new ArrayList();
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT *"
                    + "FROM `bottoms`;";

            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                price = res.getInt("price");
                variant = res.getString("variant");
                CupcakeBottom t = new CupcakeBottom(variant, price);
                CBList.add(t);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return CBList;
    }
    
    /**
     * Sets a users balance, and puts it in the database, based on the username
     * If username doesnt exists, it makes an exception
     * 
     * 
     * @param aUser who is the user thats going to get the updated balance
     */
    
    

    public void updateBalance(User aUser) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "UPDATE users"
                    + " SET balance = " + aUser.getBalance()
                    + " WHERE username = '" + aUser.getuName() + "';";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("Balance update failed!");
            ex.printStackTrace();
        }
    }
    
    /**
     * Gets the current balance of a user, taken from the database.
     * It throws an exception, if the user doesnt exist
     * 
     * 
     * @param aUser the user we are getting the balance of
     */

    public void getBalance(User aUser) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT balance FROM users"
                    + "WHERE username = '" + aUser.getuName() + "';";

            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                int newBalance = res.getInt("balance");
                aUser.setBalance(newBalance);
            }
        } catch (Exception ex) {
            System.out.println("Balance get failed!");
        }
    }
    
    /**
     * Creates a user, with the parameters name and password, 
     * and stores it in the database. The user gets the start balance of 0
     * If name and/or password isnt a string, it will throw an exception 
     * and return false.
     * At last it will return true, if its made correctly and add the user
     * 
     * 
     * @param name which is the made up username
     * @param pass which is the password thats connecting to the username
     * @return true if the userinfo is valid
     */

    public boolean insertUser(String name, String pass) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String comm
                    = "INSERT INTO `users` (username, pw, balance) "
                    + "values('" + name + "', '" + pass + "'," + 0 + ");";
            stmt.execute(comm);
        } catch (Exception ex) {
            System.out.println("Error, unable to create user");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
