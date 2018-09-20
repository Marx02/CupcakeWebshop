/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnector;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esben
 */
public class DataMapper {
    
    public User getUserInfo(String uName, String password){
        try {
            Connection c = new DBConnector().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        User a = new User("asdasd",12);
        return a;
    }
}
