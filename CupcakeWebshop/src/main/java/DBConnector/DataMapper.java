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

    public static void main(String[] args) {
        DataMapper m = new DataMapper();
        System.out.println(m.getBottom("Chocolate").getPrice());
        System.out.println(m.getTopping("Chocolate").getPrice());
        System.out.println(m.getAllBottoms().get(1).getName());
    }

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
