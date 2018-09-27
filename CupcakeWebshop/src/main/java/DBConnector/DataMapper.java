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

/**
 *
 * @author Esben
 */
public class DataMapper {
//    public static void main(String[] args) {
//        DataMapper m = new DataMapper();
//        User c = new User("Casper",420,true);
//        m.updateBalance(c);
//    }

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

    public CupcakeBottom getBottom(int bid) {
        int price;
        String variant;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT `price`, `variant`"
                    + "FROM `bottoms`"
                    + "WHERE bid =`" + bid + "`;";
            ResultSet res = st.executeQuery(query);
            price = res.getInt("price");
            variant = res.getString("variant");
        } catch (Exception ex) {
            return null;
        }
        CupcakeBottom a = new CupcakeBottom(variant, price);
        return a;
    }

    public CupcakeTopping getTopping(int tid) {
        int price;
        String variant;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT `price`, `variant`"
                    + "FROM `toppings`"
                    + "WHERE variant =`" + tid + "`;";
            ResultSet res = st.executeQuery(query);
            price = res.getInt("price");
            variant = res.getString("variant");
        } catch (Exception ex) {
            return null;
        }
        CupcakeTopping b = new CupcakeTopping(variant, price);
        return b;
    }

    public void updateBalance(User aUser) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "UPDATE users"
                    + " SET balance = " + aUser.getBalance()
                    + " WHERE username = '" + aUser.getuName()+"';";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("Balance update failed!");
            ex.printStackTrace();
        }
    }

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
