package App;

import java.sql.*;
import org.postgresql.util.PSQLException;

public class Connector {

    private static String URL = "jdbc:postgresql://127.0.0.1:5432/not_dnd_char_creator";
    //private static String USER = "postgresql";
    //private static String PWD = "";
    private static String USER = "alumne";
    private static String PWD = "alumne";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static ResultSet executeQuery(String query) {
        ResultSet rs = null;

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return rs;
    }
    public static void executeUpdate(String query) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            if(!(e instanceof PSQLException)){
                e.printStackTrace();
            }
        }
    }

}
