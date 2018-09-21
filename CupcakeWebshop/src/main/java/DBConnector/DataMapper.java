/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Esben
 */
public class DataMapper {
    
    public User getUserInfo(String uName, String password){
        User aUser = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT `balance`"
                    + "FROM `users`"
                    + "WHERE password = `"+password+"`"
                    + "AND username = `"+uName+"`;";
            ResultSet res = st.executeQuery(query);
            while(res.next()){
                aUser = new User(uName,res.getInt("balance"));
            }
        } catch (Exception ex) {
            aUser = new User(null,0);
            return aUser;
        }
        return aUser;
    }
    public int getBottomPrice(String part){
        int price;
        try{
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT `price`"
                    + "FROM `bottoms`"
                    + "WHERE variant =`"+part+"`;";
            ResultSet res = st.executeQuery(query);
            price = res.getInt("price");
        } catch (Exception ex) {
            return 0;
        }
        return price;
    }
    public int getToppingPrice(String part){
        int price;
        try{
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT `price`"
                    + "FROM `toppings`"
                    + "WHERE variant =`"+part+"`;";
            ResultSet res = st.executeQuery(query);
            price = res.getInt("price");
        } catch (Exception ex) {
            return 0;
        }
        return price;
    }
    public void updateBalance(User aUser){
        try{
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "UPDATE `users`"
                    + "SET balance ="+aUser.getBalance()
                    + "WHERE username =`"+aUser.getuName()+"`;";
            ResultSet res = st.executeQuery(query);
        } catch (Exception ex){
            System.out.println("Balance update failed!");
        }
    }
}
