package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    private Connection connection = null;

    //Constants
    private static final String IP = "139.59.214.174";
    private static final String PORT = "3306";
    public static final String DATABASE = "Cupcake_excercise";
    private static final String USERNAME = "botmarx";
    private static final String PASSWORD = "admin123";

    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }

}