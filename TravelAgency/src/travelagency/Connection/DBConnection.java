
package travelagency.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
   
    public static Connection getConnect(){
     Connection conn= null;
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagency","root","1234");
            System.out.println("Cteared");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     return conn;
    }
}
